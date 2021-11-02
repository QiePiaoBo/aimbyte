package com.dylan.learnthread.mrhuang;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Dylan
 * @Date : 2021/10/11 - 10:33
 * @Description :
 * @Function :
 */
public class ReentrantReadWriteLockDemo {

    static int a;

    public static void readA(){
        System.out.println(a);
    }

    public static void writeA(){
        a ++;
    }

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        Thread readThread1 = new Thread(()->{
           readLock.lock();
           try {
               readA();
           }finally {
               readLock.unlock();
           }
        });

        Thread readThread2 = new Thread(()->{
            readLock.lock();
            try {
                readA();
            }finally {
                readLock.unlock();
            }
        });

        Thread writeThread = new Thread(()->{
            writeLock.lock();
            try {
                writeA();
            }finally {
                writeLock.unlock();
            }
        });
        readThread1.start();
        writeThread.start();
        readThread2.start();
    }
}