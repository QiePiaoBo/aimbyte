package com.dylan.learnthread.threadcontroller;

import com.dylan.learnthread.util.SleepUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Dylan
 * @Date : 2021/6/11 - 20:49
 * @Description : 三个人约好去吃饭
 * @Function :
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Thread t1 = new Thread(()->{
            System.out.println("我是" + Thread.currentThread().getName() + ", 我在梳妆打扮。");
            SleepUtil.sleep(2000);
            try {
                System.out.println(Thread.currentThread().getName() + "打扮完毕！随时准备出发");
                cyclicBarrier.await();
                SleepUtil.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": GOGOGO");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "小丽");

        Thread t2 = new Thread(()->{
            System.out.println("我是" + Thread.currentThread().getName() + ", 我在梳妆打扮。");
            SleepUtil.sleep(4000);
            try {
                System.out.println(Thread.currentThread().getName() + "打扮完毕！随时准备出发");
                cyclicBarrier.await();
                SleepUtil.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": GOGOGO");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "小芳");

        Thread t3 = new Thread(()->{
            System.out.println("我是" + Thread.currentThread().getName() + ", 我在梳妆打扮。");
            SleepUtil.sleep(6000);
            try {
                System.out.println(Thread.currentThread().getName() + "打扮完毕！随时准备出发");
                cyclicBarrier.await();
                SleepUtil.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": GOGOGO");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "小红");

        t1.start();
        t2.start();
        t3.start();
    }


}
