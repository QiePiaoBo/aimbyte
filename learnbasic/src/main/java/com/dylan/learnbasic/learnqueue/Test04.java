package com.dylan.learnbasic.learnqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Dylan
 * @Date : 2021/6/2 - 22:23
 * @Description :
 * @Function :
 */
public class Test04 {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue sq = new SynchronousQueue();
        // 无法添加元素，因为容量是0
        // sq.add("a");
        // put方法会直接在添加元素时阻塞
        //sq.put("b");
        // 创建一个线程取数据
        new Thread(()->{
            while (true){
                try {
                    // 简单取数据并打印
                    // System.out.println(sq.take());
                    // 等待5秒，如果没有获取到值就返回Null
                    Object res = sq.poll(5, TimeUnit.SECONDS);
                    System.out.println(res);
                    if (res == null){
                        break;
                    }
                    // 这个队列不能使用peek取数据
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("Sleep");
        Thread.sleep(2000);
        System.out.println("Wake");
        // 创建一个线程放数据
        new Thread(()->{
            try {
                sq.put("a");
                sq.put("b");
                sq.put("c");
                sq.put("d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
