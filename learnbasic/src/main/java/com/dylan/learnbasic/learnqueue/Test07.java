package com.dylan.learnbasic.learnqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Dylan
 * @Date : Created in 13:33 2021/6/3
 * @Description :
 * @Function :
 */
public class Test07 {
    public static void main(String[] args) {
        /**
         * Deque是双端队列，继承了Queue,所以具备Queue一端放一端取的特性
         * 在此基础上Deque扩展了头尾操作(添加、删除、获取)的方法
         */
        Deque<String> d = new LinkedList<>();
        d.offer("a");
        d.offer("b");
        d.offer("c");
        d.offerFirst("0");
        d.offerLast("d");
        System.out.println(d);
        System.out.println(d.poll());
        System.out.println(d.pollFirst());
        System.out.println(d.pollLast());
    }
}
