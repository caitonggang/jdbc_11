package cn.itcast.day04.demo01;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/23 23:53
 * @Version 1.0
 */
public class HelloJDK9 {
    public static void main(String[] args) {
        int a = 10;
         int b = 20;
        System.out.println(a + b);
        for (int i = 0; i < 5; i++) {
            System.out.println(i);

        }
        pr();
    }

    private static void pr() {
        System.out.println(2);
    }
}