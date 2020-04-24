package cn.itcast.annotation;

import java.util.Date;

/**
 * @Author: caitonggang
 * @Description:
 * @Date: 2020/4/22 17:14
 * @Version 1.0
 */
@SuppressWarnings("all")
public class AnnoDemo1 {

    @Override
    public String  toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){

    }


    @MyAnno
    public void show2(){}

    public void demo1(){
        show1();
        Date date=new Date();
    }
}
