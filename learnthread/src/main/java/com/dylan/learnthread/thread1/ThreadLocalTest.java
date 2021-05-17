package com.dylan.learnthread.thread1;

import com.dylan.learnthread.prodcons.SleepUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @Date : Created in 16:03 2021/5/17
 * @Description :
 * @Function :
 */
public class ThreadLocalTest {

    static ThreadLocal<List<String>> localVar = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
//        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                ArrayList<String> list = new ArrayList<>();
                list.add("QWER");
                localVar.set(list);
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtil.sleep(2000);
                //设置线程1中本地变量的值
                List<String> l2 = localVar.get();
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
            }
        });

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Main");
    }
}