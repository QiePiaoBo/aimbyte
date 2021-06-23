package com.dylan.learnthread.print1by1;

import java.util.concurrent.Exchanger;

/**
 * @author Dylan
 * @Date : Created in 15:07 2021/6/23
 * @Description :
 * @Function :
 */
public class Result03_Exchanger {

    static Exchanger<Integer> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < NumStrSource.nums.length; i++) {
                    try {
                        exchanger.exchange(i);
                        System.out.print(NumStrSource.nums[i]);
                        exchanger.exchange(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < NumStrSource.chars.length; i++) {
                    try {
                        System.out.print(NumStrSource.chars[i]);
                        exchanger.exchange(i);
                        exchanger.exchange(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();


    }

}
