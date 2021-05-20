package com.dylan.learnbasic.learncollection.learnset;

import java.util.TreeSet;

/**
 * @author Dylan
 * @Date : Created in 15:40 2021/5/18
 * @Description :
 * @Function :
 */
public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("aaa");
        ts.add("bbb");
        ts.add("ccc");
        ts.add("zzz");
        ts.add("xxx");
        ts.add("qqq");
        ts.add("ddd");
        System.out.println(ts);


    }
}
