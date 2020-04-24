package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;
import java.security.acl.LastOwnerException;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/22 15:03
 * @Version 1.0
 */
public class PeflectDemo2{

    public static void main(String[] args) throws Exception {
        Class personClass= Person.class;

        Field[] fields = personClass.getFields();

        for(Field field : fields){
            System.out.println(field);
        }

        Field a = personClass.getField("a");

        Person p =new Person();
        Object value = a.get(p);
        System.out.println(value);

        //设置a的值
        a.set(p,"张三");
        System.out.println(p);

        System.out.println("===================");

/*                     * Field[] getDeclaredFields()
                * Field getDeclaredField(String name)*/

        Field[] declaredFields= personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        Field d1 = personClass.getDeclaredField("a");
        //忽略访问权限修饰符的安全检查
        d1.setAccessible(true);//暴力反射
        Object value2 = d1.get(p);
        System.out.println(value2);

        Field d = personClass.getDeclaredField("a");

        d.setAccessible(true);//暴力反射
        Object value3 =d.get(p);
        System.out.println(value3);
    }

}
