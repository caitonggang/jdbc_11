package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/22 15:03
 * @Version 1.0
 */
public class PeflectDemo4 {

    /*
		3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)

			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)

     */
    public static void main(String[] args) throws Exception {

        Class personClass=Person.class;

        Method eat_method  =personClass.getDeclaredMethod("eat");
        Person p =new Person();

        eat_method.invoke(p);

        Method eat_method2 =personClass.getDeclaredMethod("eat",String.class);
        eat_method2.invoke(p,"1");

        System.out.println("===================");


        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
            //method.setAccessible(true);
        }

        //获取类名
        String name = personClass.getName();
        System.out.println(name);
    }

}
