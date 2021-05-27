package com.dylan.learnbasic.learncow;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Dylan
 * @Date : Created in 13:35 2021/5/27
 * @Description :
 * @Function :
 */
public class Test01 {
    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // add方法，可以添加重复元素
        list.add(101);
        list.add(102);
        list.add(103);
        list.add(104);
        System.out.println(list);
        list.add(103);
        System.out.println(list);
        // addIfAbsent,只有在元素不存在时才会添加进去
        list.addIfAbsent(103);
        list.addIfAbsent(100);
        list.addIfAbsent(99);
        System.out.println(list);
    }
}
