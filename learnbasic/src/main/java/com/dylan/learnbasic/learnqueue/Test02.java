package com.dylan.learnbasic.learnqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Dylan
 * @Date : Created in 12:24 2021/6/1
 * @Description :
 * @Function :
 */
public class Test02 {

    public static void main(String[] args) throws InterruptedException {
        // ArrayBlockingQueue是一个底层基于数组的，有边界/界限的队列, FIFO 先进先出
        // 队列头部的元素的放置的时间最长，尾部的最短，即新元素在尾部添加，查询元素从头部开始
        ArrayBlockingQueue<String> arr = new ArrayBlockingQueue<>(3);
        // 不可以添加空元素，会报空指针,当队列满时会报错
        arr.add("ADD");
        // offer会返回一个布尔值，插入失败返回false，插入成功返回true
        arr.offer("OFFER1");
        arr.offer("OFFER1");
        Thread.sleep(2000);
        // 获取元素，获取第一个元素并从队列中取出，take在队列为空时阻塞
        System.out.println(arr.take());
        // ArrayBlocking特有的，得到头部元素但是不将其移除，队列空时返回值为null
        System.out.println(arr.peek());
        // 获取头元素并将其从队列中移除，队列空时返回值为null
        System.out.println(arr.poll());
        // 获取头元素并将其从队列中移除，可以设置超时时间
        System.out.println(arr.poll(2, TimeUnit.SECONDS));
        // offer允许添加元素时设置超时时间
        arr.offer("WAIT", 3, TimeUnit.SECONDS);
        Thread.sleep(2000);
        System.out.println(arr.take());
        // 这个方法是阻塞的,会一直阻塞
        arr.put("PUT");
        System.out.println(arr);
    }
}
