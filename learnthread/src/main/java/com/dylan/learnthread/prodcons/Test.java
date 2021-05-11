package com.dylan.learnthread.prodcons;

/**
 * @author Dylan
 * @Date : Created in 13:37 2021/5/11
 * @Description :
 * @Function :
 */
public class Test {

    public static void main(String[] args) {
        Student s = new Student();
        Producer producer = new Producer(s);
        Consumer consumer = new Consumer(s);


        Thread tp = new Thread(producer, "Producer");
        Thread tc = new Thread(consumer, "Consumer");

        tp.start();
        tc.start();
    }
}
