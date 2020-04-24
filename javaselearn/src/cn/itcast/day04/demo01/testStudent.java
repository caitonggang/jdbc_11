package cn.itcast.day04.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/23 13:52
 * @Version 1.0
 */
public class testStudent {


    public static void main(String[] args) {
/*        Student s1 = new Student();
        s1.setName("张三");
        System.out.println(s1);
        System.out.println(s1.getName());
        Student s2 = new Student("1", 1, "1");
        System.out.println(s2);
        String s = s2.toString();
        System.out.println(s);
        String string = s2.toString();
        System.out.println("print number");
        Scanner sc =new Scanner(System.in);
        Scanner sc2 =new Scanner(System.in);
        int i =sc.nextInt();
        int j =sc2.nextInt();
        System.out.println(i+j);
        System.out.println(i);*/
        Random random = new Random();
        for (int i1 = 0; i1 < 5; i1++) {
            int number = random.nextInt();
            System.out.println(number);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(3);

        System.out.println(list.get(1));
        System.out.println(list);

        Random random1 = new Random();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i2 = 0; i2 < 6; i2++) {
            int random2 = random1.nextInt(33);
            list2.add(random2);
        }
        System.out.println(list2);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        //迭代器
        Collection<String> coll = new ArrayList<>();
        coll.add("1");
        coll.add("1");
        coll.add("1");
        coll.add("1");

        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        //创建集合对象
        Collection<String> coll1 = new ArrayList<>();
        //添加元素
        coll1.add("12");
        coll1.add("13");
        coll1.add("14");
        coll1.add("15");
        //遍历  使用迭代器
        Iterator<String> it2 = coll1.iterator();
        //输出
        while (it2.hasNext()) {
            String s2 = it2.next();
            System.out.println(s2);
        }
        for (String s : coll1) {
            System.out.println(s);
        }
        for (String s1 : coll) {
            System.out.println(s1);

        }
        //
        //
    }

}
