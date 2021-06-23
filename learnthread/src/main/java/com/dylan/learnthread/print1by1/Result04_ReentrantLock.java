package com.dylan.learnthread.print1by1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dylan
 * @Date : Created in 15:38 2021/6/23
 * @Description :
 * @Function :
 */
public class Result04_ReentrantLock {



    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        Condition num = reentrantLock.newCondition();
        Condition str = reentrantLock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < NumStrSource.nums.length; i++) {
                        reentrantLock.lock();
                        num.await();
                        System.out.print(NumStrSource.nums[i]);
                        str.signalAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < NumStrSource.chars.length; i++) {
                        reentrantLock.lock();
                        System.out.print(NumStrSource.chars[i]);
                        num.signalAll();
                        str.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }

        }, "t2");

        t1.start();
        t2.start();


    }


}
