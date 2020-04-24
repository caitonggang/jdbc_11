package cn.itcast.day04.demo01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/23 20:54
 * @Version 1.0
 */

public class MapDemo {
    public static void main(String[] args) {
        //创建 map对象
        HashMap<String, String> map = new HashMap<String, String>();

        //添加元素到集合
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("邓超", "孙俪");
        System.out.println(map);

        //String remove(String key)
        System.out.println(map.remove("邓超"));
        System.out.println(map);

        // 想要查看 黄晓明的媳妇 是谁
        System.out.println(map.get("黄晓明"));
        System.out.println(map.get("邓超"));

        HashMap<Integer, String > map1=new HashMap<>();
        map1.put(1,"222");
        map1.put(5,"522");
        map1.put(3,"t22");
        map1.put(2,"622");
        System.out.println(map1);
        System.out.println(map1.remove(2));
        System.out.println(map1);
        System.out.println(map1.get(5));
        System.out.println(map1.get(2));
        System.out.println(map1.get(3));

        Set<String > keys =map.keySet();
        for (String key : keys) {
            String value=map.get(key);
            System.out.println(value);

        }

    }
}
