package cn.itcast.day04.demo01;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/24 18:04
 * @Version 1.0
 */
public class MyThread extends Thread {
    /**
     * 利用继承中的特点 * 将线程名称传递 进行设置
     */
    public MyThread(String name) {
        super(name);
    }

    /**
     * 重写run方法 * 定义线程要执行的代码
     */
    @Override
    public void run() {
        System.out.println("run线程开启");
        for (int i = 0; i < 20; i++) { //getName()方法 来自父亲

//getName()方法 来自父亲
            System.out.println(getName() + i);
        }
    }
}
