package com.atguigu3.preparedstatement.crud;

import com.atguigu2.statement.User;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @Author: caitonggang
 * @Description: 演示使用PreparedStatement替换Statement，解决SQL注入问题
 * @Date: 2020/4/21 10:34
 * @Version 1.0
 *
 * 除了解决Statement 的拼串、sql问题以外，PrepareStatement还有什么好处
 * 1.PreparedStatement操作Blob的数据，而Statement做不到
 * 2.PreparedStatement可以实现更高效的批量操作
 */
public class PreparedStatementTest {

    @Test
    public void testLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String user = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();
        //SELECT user,password FROM user_table WHERE user = '1' or ' AND password = '=1 or '1' = '1'
        String sql = "SELECT user,password FROM user_table WHERE user = ? and password = ?";
        User returnUser = getInstance(User.class,sql,user,password);
        if(returnUser != null){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名不存在或密码错误");
        }
    }
    /*
     * @author 小哥
     * @Description 针对于不同的表的通用的查询操作，返回表中的一条记录
     * @Date 0:13 2020/4/21
     * @Param &param&
     * @return
     **/
    public <T> T  getInstance(Class<T> clazz,String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据  ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {

                    //获取列的值
                    Object columValue = rs.getObject(i + 1);

                    //获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给cust对象指定的columnName属性，赋值columValue：通过反射

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            JDBCUtils.closeResource(conn,ps,rs);

        }
        return null;
    }
}
