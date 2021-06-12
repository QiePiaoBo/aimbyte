package com.dylan.learnthread.threadcontroller;

import com.dylan.learnthread.util.SleepUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dylan
 * @Date : 2021/6/11 - 21:11
 * @Description :
 * @Function :
 */
public class TestWaitNotify {
    public static void main(String[] args) {
        Object lock = new Object();
        AtomicInteger aInt = new AtomicInteger(0);
        Thread tA = new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + ": 为所欲为 + " + aInt.incrementAndGet() + ".");
                SleepUtil.sleep(1000);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": 为所欲为 + " + aInt.incrementAndGet() + ".");
                SleepUtil.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": 为所欲为 + " + aInt.incrementAndGet() + ".");
            }
        }, "A");
        Thread tB = new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + ": 为所欲为 + " + aInt.incrementAndGet() + ".");
                SleepUtil.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": 为所欲为 + " + aInt.incrementAndGet() + ".");
                SleepUtil.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": 为所欲为 + " + aInt.incrementAndGet() + ".");
                SleepUtil.sleep(1000);
                lock.notify();
            }
        }, "B");

        tA.start();
        tB.start();
    }
}
