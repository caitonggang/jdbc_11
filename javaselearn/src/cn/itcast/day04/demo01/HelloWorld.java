package cn.itcast.day04.demo01;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/23 11:02
 * @Version 1.0
 */
public class HelloWorld {


    public static int getSum(int y) {
        int sum = 0;
        for (int i = 0; i <= y; i++) {
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }

    public static int getSumd(int x,int y){
        return x+y;
    }

    public static void main(String[] args) {
        int sum = 0;
        sum = getSum(2);
        System.out.println(sum);
        sum = getSumd(1,2);

        System.out.println(sum);
    }


}
