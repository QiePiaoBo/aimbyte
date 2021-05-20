package com.dylan.learnbasic.learncollection.lkdlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Dylan
 * @Date : Created in 13:39 2021/5/17
 * @Description :
 * @Function :
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("ddd");
        System.out.println(list);// LinkedList可以添加重复数据
        list.addFirst("addHead");// 添加到头部
        list.addLast("addTail");// 添加到尾部
        System.out.println(list);
        list.offer("offer");// 添加到尾部
        System.out.println(list);
        list.offerFirst("offerHead");
        list.offerLast("offerTail");
        System.out.println(list);
        System.out.println(list.poll());// 取出并删除第一个元素
        System.out.println(list.pollFirst());// 取出并删除头部元素
        System.out.println(list.pollLast());// 取出并删除尾部元素
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list);
//        list.clear();
//        System.out.println(list);
//        System.out.println(list.pollFirst());
//        System.out.println(list.removeFirst());// Exception in thread "main" java.util.NoSuchElementException
        // poll 是jdk1.6新出的方法，提高了代码的健壮性
        // 遍历
        System.out.println("------遍历------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (String s : list){
            System.out.println(s);
        }
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        // 这种写法节省了内存，it1的生命周期会随着for循环的结束而结束
        for (Iterator it1 = list.iterator();it1.hasNext();){
            System.out.println(it.next());
        }
    }
}
