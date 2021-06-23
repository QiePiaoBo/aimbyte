package com.dylan.learnthread.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @author Dylan
 * @Date : 2021/6/23 - 23:13
 * @Description :
 * @Function :
 */
public class MyRejectedHandler {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6), new MyHandler());
    }

    static class MyHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("log : r rejected");
            System.out.println("save r to mysql kafka redis");
            System.out.println("try 3 times");
            if (executor.getQueue().size() < 10000){
                System.out.println(" try put again ");
            }
        }
    }
}
