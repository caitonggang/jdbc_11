package com.atguigu3.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: caitonggang
 * @Date: 2020/4/20 14:53
 * @Description:操作数据库工具类
 *
 */
public class JDBCUtils {
    /*
    * @author 小哥
    * @Description 获取数据库连接
    * @Date 15:11 2020/4/20
    * @Param &param&
    * @return
    **/


    public static Connection getConnection() throws Exception{
        //1.读取配置文件中的4个基本信息
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros =new Properties();
        pros.load(resourceAsStream);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    /*
    * @author 小哥
    * @Description 关闭连接和Statement操作
    * @Date 15:29 2020/4/20
    * @Param &param&
    * @return
    **/
    public static void closeResource(Connection connection, Statement ps){
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
    /*
    * @author 小哥
    * @Description 关闭资源操作
    * @Date 17:03 2020/4/20
    * @Param &param&
    * @return
    **/
    public static void closeResource(Connection connection, Statement ps,ResultSet rs){
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
        try {
            if (rs!=null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
