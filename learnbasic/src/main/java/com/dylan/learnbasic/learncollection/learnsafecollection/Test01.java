package com.dylan.learnbasic.learncollection.learnsafecollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Dylan
 * @Date : Created in 12:49 2021/5/26
 * @Description :
 * @Function :
 */
public class Test01 {

    public static void main(String[] args) {
        testCollectionSynchroniedList();
        testUnsafeArrayList();
        // 结果 Collections.synchronizedList()方法获取的List对象是线程安全的
    }

    /**
     * 利用Collections.synchronizedList()获取一个线程安全的List
     */
    private static void testCollectionSynchroniedList(){
        System.out.println("-------------testCollectionSynchroniedList-------------");
        // ArrayList从线程不安全到线程安全，获取线程安全的ArrayList的一种方式
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        // 创建一个线程池
        ExecutorService es = Executors.newFixedThreadPool(100);
        // 并发向集合中添加10000个数据
        for (int i = 0; i < 10000; i++) {
            es.execute(()->{
                list.add("aaa");
            });
        }
        // 关闭线程池资源
        es.shutdown();
        // 监控线程是否执行完毕
        while (true){
            if (es.isTerminated()){
                System.out.println("所有子线程都已执行完毕。");
                System.out.println(list.size());
                if (list.size() == 10000){
                    System.out.println("线程安全");
                }else {
                    System.out.println("线程不安全");
                }
                break;
            }
        }
    }

    /**
     * 测试ArrayList的线程不安全性。
     * 原理：（当一个线程插入数据时，另一个线程也可以插入数据）-->线程不安全，最终导致插入的数量和插入的次数不相等
     */
    private static void testUnsafeArrayList(){
        System.out.println("-------------testUnsafeArrayList-------------");
        ArrayList<String> list = new ArrayList<>();
        // 创建一个线程池
        ExecutorService es = Executors.newFixedThreadPool(100);
        // 并发向集合中添加10000个数据
        for (int i = 0; i < 10000; i++) {
            es.execute(()->{
                list.add("aaa");
            });
        }
        // 关闭线程池资源
        es.shutdown();
        // 监控线程是否执行完毕
        while (true){
            if (es.isTerminated()){
                System.out.println("所有子线程都已执行完毕。");
                System.out.println(list.size());
                if (list.size() == 10000){
                    System.out.println("线程安全");
                }else {
                    System.out.println("线程不安全");
                }
                break;
            }
        }
    }


}
