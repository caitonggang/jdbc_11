package com.atguigu3.preparedstatement.crud;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @Author: caitonggang
 * @Description: 针对于Customers表的查询操作
 * @Date: 2020/4/20 16:36
 * @Version 1.0
 */
public class CustomerForQuery {
    /*
    * @author 小哥
    * @Description 针对customers表的通用的查询操作
    * @Date 17:14 2020/4/20
    * @Param &param&
    * @return
    **/

    @Test
    public void testQueryForCustomers(){
        String sql="select id,name,birth,email from customers where id = ?";
        String sql1 = "select id,name from customers where id = ?";

        Customer customer =queryForCustomers(sql,14);
        System.out.println(customer);
        Customer customer1=queryForCustomers(sql1,1);
        System.out.println(customer1);
    }
    public Customer queryForCustomers(String sql,Object ...args)  {
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
                Customer cust = new Customer();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {

                    //获取列的值
                    Object columValue = rs.getObject(i + 1);

                    //获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给cust对象指定的columnName属性，赋值columValue：通过反射

                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(cust, columValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            JDBCUtils.closeResource(conn,ps,rs);

        }
        return null;
    }
    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql ="select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);

            //执行
            resultSet = ps.executeQuery();
            //处理结果集
            if(resultSet.next()) {//判断结果集的下一条是否有数据，如果有数据返回true，并且指针下移，如果返回false，指针不会下移
            //获取当前数据的各个字段值
                int id =resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth =resultSet.getDate(4);

//                //方式一：
//                System.out.println("id= "+ id + ", name = " + name + ", email " +email +", birth " +birth);
//
//                //方式二：
//                Object[] data = new Object[]{id,name,email,birth};
//
                //方式三：将数据封装为一个对象（推荐）
                Customer customer=new Customer(id,name,email,birth);
                System.out.println(customer);



            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps,resultSet);
        }


    }

}
