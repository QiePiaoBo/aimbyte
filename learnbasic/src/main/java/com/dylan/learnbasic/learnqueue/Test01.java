package com.dylan.learnbasic.learnqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Dylan
 * @Date : 2021/5/31 - 23:07
 * @Description :
 * @Function :
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bl = new ArrayBlockingQueue<>(2);

        // 插入，成功时返回true，没空间时抛出IllegalStateException
        bl.add("A");
        // 插入，成功时返回true,没空间时返回false
        bl.offer("B");
        // 插入，会等待有可用空间， put是阻塞的
        Thread t = new Thread(()->{
            try {
                bl.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(1000);
        // 获取并移除队列的头部，在可以获取到之前会一直等待 take是阻塞的
        String take = bl.take();
        System.out.println(take);
        // 获取并移除队列的头部，可以设置等待时间，在超过这个时间之前不会
        System.out.println(bl.poll(2, TimeUnit.SECONDS));
        Thread.sleep(1000);
        // 从队列中移除
        bl.remove("C");
        System.out.println(bl);
    }
}
