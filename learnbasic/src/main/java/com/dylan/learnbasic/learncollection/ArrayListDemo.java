package com.dylan.learnbasic.learncollection;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author Dylan
 * @Date : 2021/5/17 - 22:38
 * @Description :
 * @Function :
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> li = new ArrayList<>();
        li.add("aa");
        li.add("bb");
        li.add("cc");
        li.add("dd");
        ListIterator<String> it = li.listIterator();
        while (it.hasNext()){
            if ("cc".equals(it.next())){
                it.add("kk");
            }
        }
        // 是否含有下一个元素
        System.out.println(it.hasNext());
        // 是否含有上一个元素
        System.out.println(it.hasPrevious());
        // 逆向遍历
        while (it.hasPrevious()){
            System.out.println(it.previous());
        }
        System.out.println(it.hasNext());
        System.out.println(it.hasPrevious());
        // 打印List
        System.out.println(li);
    }
}
