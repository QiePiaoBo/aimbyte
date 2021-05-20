package com.dylan.learnbasic.learncollection.learnset;

import java.util.StringJoiner;

/**
 * @author Dylan
 * @Date : Created in 15:11 2021/5/18
 * @Description :
 * @Function :
 */
public class Test {
    public static void main(String[] args) {

        StringJoiner sj = new StringJoiner(",");
        sj.add("hello");
        sj.add("hello");
        sj.add("hello");
        sj.add("hello");
        System.out.println(sj);
    }
}
