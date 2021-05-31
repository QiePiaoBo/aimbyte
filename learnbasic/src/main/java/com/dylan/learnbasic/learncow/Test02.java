package com.dylan.learnbasic.learncow;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Dylan
 * @Date : 2021/5/31 - 22:42
 * @Description :
 * @Function :
 */
public class Test02 {
    public static void main(String[] args) {
        // 创建一个集合
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(7);
        // set不能放重复数据，List可以 这是两者的本质区别
        // set的add方法不可以放重复数据
        System.out.println(set);
    }

}
