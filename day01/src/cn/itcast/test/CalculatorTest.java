package cn.itcast.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/22 12:21
 * @Version 1.0
 */
public class CalculatorTest {


    @Before
    public void init(){
        System.out.println("init");

    }

    @After
    public void close(){
        System.out.println("close");
    }
    /**
     * 测试add方法
     *
     */
    @Test
    public void testAdd(){
       // System.out.println("我被执行了");
        //调用

        //1.创建计算器对象
        Calculator c =new Calculator();

        //2.调用add方法
        int result = c.add(1,2);
        //3.断言  我断言这个结果是3
        Assert.assertEquals(-1,result);
        System.out.println("test");
       /* int result = c.add(1, 2);
        System.out.println(result);*/

/*        int result = c.sub(1, 1);
        System.out.println(result);*/

        String str = "abc";

    }

}
