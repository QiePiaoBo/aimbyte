package com.dylan.learnthread.thread1;

/**
 * @author Dylan
 * @Date : Created in 16:14 2021/4/25
 * @Description :  synchronized是不是可重入的？必须是，如果不能重入的话synchronized的可用性会降低，
*                  因为对加锁的方法的调用是很常见的，如果不可重入那么死锁的可能性会非常大
 * @Function :
 */
public class Demo3 {

    public synchronized void m1(){
        System.out.println("m1 start.");
        m2();
        System.out.println("m1 stop.");
    }

    public synchronized void m2(){
        System.out.println("m2 start.");
        System.out.println("m2 stop.");
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        demo3.m1();
    }
}
