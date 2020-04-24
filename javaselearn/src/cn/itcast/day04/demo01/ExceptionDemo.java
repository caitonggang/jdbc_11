package cn.itcast.day04.demo01;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/24 0:17
 * @Version 1.0
 */
public class ExceptionDemo {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        int[] arr = { 34, 12, 67 };
        int num = ArrayTools.getElement(arr, 4);
        System.out.println("num=" + num);
        System.out.println("over");
    }
}