package cn.itcast.day04.demo01;

import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/23 18:37
 * @Version 1.0
 */
public class Demo01Generic {

    public static void main(String[] args) {

        show2();
        show2();
        Object object=new Object();
        int object1=object.hashCode();
        System.out.println(object1);
        System.out.println(object);
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());

        Student student1=new Student("xx",1,"1");
        Student student2=new Student("xx",2,"1");
        Student student3=new Student("xx",3,"2");
        Student student4=new Student("xx",4,"2");
        Student student5=new Student("xx",5,"2");

        HashSet<Student> set= new HashSet<>();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        set.add(student5);
        System.out.println(set);
    }

    private static void show2() {
   ArrayList<String > list=new ArrayList<>();
   list.add("1");
   list.add("1");

//   list.add(1);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s=iterator.next();
            System.out.println(s);
        }

    }

    private static void show() {
    ArrayList list= new ArrayList();
    list.add("1222ed");
    list.add(1);

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj=it.next();
            System.out.println(obj);
        String s=(String) obj;
        System.out.println(s);
        }

    }
}
