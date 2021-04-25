package com.dylan.learnthread.thread1;

/**
 * @author Dylan
 * @Date : Created in 16:20 2021/4/25
 * @Description : 程序出现异常，锁会自动释放
 * @Function :
 */
public class Demo4 {

    static int a = 1;

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " : m1 start.");
        a += 1;
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " : " + e.getMessage());
            throw e;
        }


        System.out.println(Thread.currentThread().getName() + " : m1 stop.");
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();

        new Thread(() -> {
            demo4.m1();
        }, "t1").start();

        new Thread(() -> {
            demo4.m1();
        }, "t2").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
