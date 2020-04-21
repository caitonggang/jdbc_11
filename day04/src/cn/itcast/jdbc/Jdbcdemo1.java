package cn.itcast.jdbc;


import java.sql.Driver;
import java.sql.DriverManager;

/*
* JDBC快速入门
*
* */
public class Jdbcdemo1 {
    public static void main(String args[]) throws Exception {

        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        DriverManager.getConnection(;

    }
}
