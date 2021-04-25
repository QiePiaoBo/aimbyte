package com.dylan.learnthread.thread1;


import static javafx.scene.input.KeyCode.T;

/**
 * @author Dylan
 * @Date : Created in 15:55 2021/4/25
 * @Description : 可以同时调用对象的synchronized和非synchronized方法
 * @Function :
 */
public class Demo0 {

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " : m1 start.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : m1 end.");
    }

    public void m2(){
        System.out.println(Thread.currentThread().getName() + " : m2 start.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : m2 end.");
    }

    public static void main(String[] args) {
        Demo0 demo0 = new Demo0();
        new Thread(()->{
            demo0.m1();
        }, "t1").start();

        new Thread(()->{
            demo0.m2();
        }, "t2").start();
    }

}
