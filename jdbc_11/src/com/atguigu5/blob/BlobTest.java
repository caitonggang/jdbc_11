package com.atguigu5.blob;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @Author: caitonggang
 * @Description: 测试使用ProparedStatement操作Blob类型的字段
 * @Date: 2020/4/21 15:18
 * @Version 1.0
 */
public class BlobTest {

    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() throws Exception {
        Connection conn= JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement ps=conn.prepareStatement(sql);

        ps.setObject(1,"xxx");
        ps.setObject(2,"2");
        ps.setObject(3,"1999-9-9");
        FileInputStream is = new FileInputStream(new File("1111.jpg"));
        ps.setObject(4,is);

        ps.execute();

        JDBCUtils.closeResource(conn,ps);

    }

    //查询数据表customers中Blob类型的字段
    @Test
    public void testQuery() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FileOutputStream fos =null;
        InputStream is=null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="select id,name,email,birth,photo from customers where id =?";
            ps = conn.prepareStatement(sql);

            ps.setInt(1,16);

            rs = ps.executeQuery();

            if(rs.next()){
    //方式一：
    //            int id = rs.getInt(1);
    //            String name = rs.getString(2);
    //            String email = rs.getString(3);
    //            Date birth = rs.getDate(4);

                //方式二：
                int id =rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust =new Customer(id,name,email,birth);
                System.out.println(cust);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos =new FileOutputStream("caitonggang.jpg");
                byte[] buffer =new byte[1024];
                int len;
                while((len =is.read(buffer))!=-1){
                    fos.write(buffer,0,len);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(is !=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JDBCUtils.closeResource(conn,ps,rs);
        }

    }
//  //查询数据表customers中Blob类型的字段
//  @Test
//  public void testQuery(){
//      Connection conn = null;
//      PreparedStatement ps = null;
//      InputStream is = null;
//      FileOutputStream fos = null;
//      ResultSet rs = null;
//      try {
//          conn = JDBCUtils.getConnection();
//          String sql = "select id,name,email,birth,photo from customers where id = ?";
//          ps = conn.prepareStatement(sql);
//          ps.setInt(1, 24);
//          rs = ps.executeQuery();
//          if(rs.next()){
//              //			方式一：
//              //			int id = rs.getInt(1);
//              //			String name = rs.getString(2);
//              //			String email = rs.getString(3);
//              //			Date birth = rs.getDate(4);
//              //方式二：
//              int id = rs.getInt("id");
//              String name = rs.getString("name");
//              String email = rs.getString("email");
//              Date birth = rs.getDate("birth");
//
//              Customer cust = new Customer(id, name, email, birth);
//              System.out.println(cust);
//
//              //将Blob类型的字段下载下来，以文件的方式保存在本地
//              Blob photo = rs.getBlob("photo");
//              is = photo.getBinaryStream();
//              fos = new FileOutputStream("zhangyuhao.jpg");
//              byte[] buffer = new byte[1024];
//              int len;
//              while((len = is.read(buffer)) != -1){
//                  fos.write(buffer, 0, len);
//              }
//
//          }
//      } catch (Exception e) {
//          e.printStackTrace();
//      }finally{
//
//          try {
//              if(is != null)
//                  is.close();
//          } catch (IOException e) {
//              e.printStackTrace();
//          }
//
//          try {
//              if(fos != null)
//                  fos.close();
//          } catch (IOException e) {
//              e.printStackTrace();
//          }
//
//          JDBCUtils.closeResource(conn, ps, rs);
//      }
//

  }


