package cn.itcast.day04.demo02;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/24 18:28
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) {
//    创建线程任务对象
        Ticket ticket = new Ticket(); //创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");
//     同时卖票
        t1.start();
        t2.start();
        t3.start();
    }
}
