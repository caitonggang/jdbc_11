package cn.itcast.day04.demo01;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/24 18:26
 * @Version 1.0
 */
public class Ticket implements Runnable {
    private int ticket = 100;
    Object object=new Object();
    /**
     * 执行卖票操作
     */
    @Override
    public void run() { //每个窗口卖票的操作 //窗口 永远开启
        while (true) {
           synchronized (object){
               if (ticket > 0) {//有票 可以卖 //出票操作 //使用sleep模拟一下出票时间
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) { // TODO Auto‐generated catch block
                       e.printStackTrace();
                   }//获取当前线程对象的名字
                   String name = Thread.currentThread().getName();
                   System.out.println(name + "正在卖:" + ticket--);
               }
           }
        }
    }
}