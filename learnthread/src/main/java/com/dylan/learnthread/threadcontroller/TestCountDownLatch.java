package com.dylan.learnthread.threadcontroller;

import com.dylan.learnthread.util.SleepUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author Dylan
 * @Date : 2021/6/11 - 20:27
 * @Description : 关灯，等三个部门的员工都走了关灯
 * @Function :
 */
public class TestCountDownLatch {


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread t1 = new Thread(()->{
            System.out.println("下班时间: " + Thread.currentThread().getName() + " 准备关灯.");
            System.out.println("巡查各部门情况...");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("都走了开始关灯.");
            SleepUtil.sleep(1000);
            System.out.println("报告: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " " + Thread.currentThread().getName() + " 关灯完毕.");
            }, "物业");

        Thread t2 = new Thread(()->{
            System.out.println("查看: " + Thread.currentThread().getName() + " 情况.");
            SleepUtil.sleep(8000);
            countDownLatch.countDown();
            System.out.println("注意: " + Thread.currentThread().getName() + " 都走了.");
        }, "部门1");

        Thread t3 = new Thread(()->{
            System.out.println("查看: " + Thread.currentThread().getName() + " 情况.");
            SleepUtil.sleep(6000);
            countDownLatch.countDown();
            System.out.println("注意: " + Thread.currentThread().getName() + " 都走了.");
        }, "部门2");

        Thread t4 = new Thread(()->{
            System.out.println("查看: " + Thread.currentThread().getName() + " 情况.");
            SleepUtil.sleep(2000);
            countDownLatch.countDown();
            System.out.println("注意: " + Thread.currentThread().getName() + " 都走了.");
        }, "部门3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }



}
