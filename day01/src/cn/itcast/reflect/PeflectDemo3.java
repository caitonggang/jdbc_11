package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/22 15:03
 * @Version 1.0
 */
public class PeflectDemo3 {

    /*
    获取构造方法们
			* Constructor<?>[] getConstructors()
			* Constructor<T> getConstructor(类<?>... parameterTypes)

			* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
			* Constructor<?>[] getDeclaredConstructors()
     */
    public static void main(String[] args) throws Exception {
        Class personClass= Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //c创建对象
        Object obj =constructor.newInstance("张三",3);
        System.out.println(obj);


        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        //c创建对象
        Object obj1 =constructor1.newInstance();
        System.out.println(obj1);

        Object o = personClass.newInstance();
        System.out.println(o);

        System.out.println(o == obj);


    }

}
