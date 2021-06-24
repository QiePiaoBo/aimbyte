package com.dylan.learnthread.ThreadPoolExecutor;

import javafx.concurrent.Task;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author Dylan
 * @Date : 2021/6/24 - 22:07
 * @Description :
 * @Function :
 */
public class MyForkJoinPool {

    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("Result of stream: " + Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveAction {

        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM){
                long sum = 0l;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from: " + start + " to: " + end + " = " + sum);
            }else {
                int middle = start + (end - start) / 2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }

    static class AddTaskRet extends RecursiveTask<Long>{

        private static final long serialVersionUID = 1l;
        int start, end;

        public AddTaskRet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if (end - start <= MAX_NUM){
                long sum = 0l;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            }
                int middle = start + (end - start) / 2;
                AddTaskRet subTask1 = new AddTaskRet(start, middle);
                AddTaskRet subTask2 = new AddTaskRet(middle, end);
                subTask1.fork();
                subTask2.fork();

                return subTask1.join() + subTask2.join();
        }
    }

    public static void main(String[] args) throws IOException {
        // 无返回值
//        ForkJoinPool fjp = new ForkJoinPool();
//        AddTask addTask = new AddTask(0, nums.length);
//        fjp.execute(addTask);
//        System.in.read();

        // 有返回值
        ForkJoinPool fjp1 = new ForkJoinPool();
        AddTaskRet addTaskRet = new AddTaskRet(0, nums.length);
        fjp1.execute(addTaskRet);
        long result = addTaskRet.join();
        System.out.println("Result of forkJoinPool: " + result);
    }
}
