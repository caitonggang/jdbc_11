package com.atguigu3.bean;

import java.util.Date;

/**
 * @Author: caitonggang
 * @Description: ORM编程思想（object relational mapping）
 *              一个数据表对应一个java类
 *              表中的一个字段对应java类的一个字段
 *              表中的一个字段对应java类的一个属性
 *              //alt+ins  加入带参的构造器，get，set方法，toString方法
 * @Date: 2020/4/20 16:49
 * @Version 1.0
 */
public class Customer {

    private int id;
    private String name;
    private String email;
    private Date birth;

    public Customer(){
        super();
    }
    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
