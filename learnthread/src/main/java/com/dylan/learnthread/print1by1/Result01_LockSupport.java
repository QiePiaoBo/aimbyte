package com.dylan.learnthread.print1by1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Dylan
 * @Date : Created in 14:07 2021/6/23
 * @Description :
 * @Function :
 */
public class Result01_LockSupport {
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 26; i++) {
                        LockSupport.park();
                        System.out.print(NumStrSource.nums[i]);
                        LockSupport.unpark(t2);
                }
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 26; i++) {
                    System.out.print(NumStrSource.chars[i]);
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
            }
        });

        t1.start();
        t2.start();
    }


}
