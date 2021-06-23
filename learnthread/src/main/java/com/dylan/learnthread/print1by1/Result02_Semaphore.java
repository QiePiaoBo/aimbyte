package com.dylan.learnthread.print1by1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Dylan
 * @Date : Created in 14:39 2021/6/23
 * @Description :
 * @Function :
 */
public class Result02_Semaphore {

    static Semaphore s1 = new Semaphore(1, true);
    static Semaphore s2 = new Semaphore(1, true);

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < NumStrSource.nums.length; i++) {
                    try {
                        System.out.print(NumStrSource.nums[i]);
                        s1.release();
                        s2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < NumStrSource.chars.length; i++) {
                    try {
                        s1.acquire();
                        System.out.print(NumStrSource.chars[i]);
                        s1.release();
                        s2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                s2.release();
            }
        }, "t2");

        t1.start();
        t2.start();

    }

}
