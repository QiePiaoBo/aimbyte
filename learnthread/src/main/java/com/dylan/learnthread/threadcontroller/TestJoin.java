package com.dylan.learnthread.threadcontroller;

import com.dylan.learnthread.util.SleepUtil;

/**
 * @author Dylan
 * @Date : 2021/6/11 - 21:03
 * @Description :
 * @Function :
 */
public class TestJoin {

    public static void main(String[] args) {

        Thread tA = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                write(Thread.currentThread().getName() + " write " + i);
                SleepUtil.sleep(1000);
            }
        }, "A");
        Thread tB = new Thread(()->{
            try {
                tA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                write(Thread.currentThread().getName() + " write " + i);
            }
        }, "B");

        tB.start();
        tA.start();

    }
    public static void write(String s){
        System.out.println(s);
    }

}
