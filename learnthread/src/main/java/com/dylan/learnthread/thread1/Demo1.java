package com.dylan.learnthread.thread1;

/**
 * @author Dylan
 * @Date : Created in 16:05 2021/4/25
 * @Description : 银行账户只对写方法加锁
 * @Function :
 */
public class Demo1 {
    private int money;



    public Demo1() {
    }

    public int getMoney() {
        return money;
    }

    public synchronized void setMoney(int money) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.money = money;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        new Thread(()->{demo1.setMoney(10000);}, "set").start();
        new Thread(()->{
            System.out.println(demo1.getMoney());
        }, "get").start();
    }
}
