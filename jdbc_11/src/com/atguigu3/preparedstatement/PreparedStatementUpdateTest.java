package com.atguigu3.preparedstatement;

/*
*
*
*使用PreparedStatement来替换Statement,实现对数据表的增删改操作
*
*
*增删改  查
*
*  */

import com.atguigu1.connection.ConnectionTest;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.SimpleTimeZone;

public class PreparedStatementUpdateTest {

    @Test
    public void testCommonUpdate()  {
/*
        String sql ="delete from customers where id =?";
        update(sql,21);
*/
        String sql="update `order` set order_name = ? where order_id = ?";
        update(sql,"蔡统港","1");

    }


    //通用的增删改操作
    public void update(String sql,Object ...args) {//sql中占位符的个数与可变形参的长度相同
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);//小心参数声明错误！！！
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn,ps);
        }

    }

    //修改customers表的一条记录
    @Test
    public void testUpdate(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            String sql="update customers set name = ? where id =?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1,"莫扎特");
            ps.setObject(2,18);
            //4.执行
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn,ps);
        }

    }
    //想customers表中添加一条记录
    @Test
    public void testConnection5() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try{
        //1.读取配置文件中的4个基本信息
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros;
        pros = new Properties();
        pros.load(resourceAsStream);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        connection = DriverManager.getConnection(url, user, password);

//        System.out.println(connection);

//        4.预编译sql语句，返回PreparedStatement的实例
        String sql = "insert into customers(name,email,birth)values(?,?,?)";//?占位符
        ps = connection.prepareStatement(sql);

        //5.填充占位符
        ps.setString(1, "哪吒2");
        ps.setString(2, "nezha@gmail.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf.parse("1000-01-01");
        ps.setDate(3, new java.sql.Date(date.getTime()));

        //6.执行操作
        ps.execute();
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        //7.资源的关闭

            try {
                if (ps!=null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection!=null)
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        }

}



