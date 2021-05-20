package com.dylan.learnbasic.learncollection.learnset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Dylan
 * @Date : Created in 12:36 2021/5/18
 * @Description :
 * @Function :
 */
public class TestInteger {

    public static void main(String[] args) {
        // 创建一个HashSet
        HashSet<Integer> hs = new HashSet<>();
        System.out.println(hs.add(19));
        hs.add(25);
        hs.add(34);
        System.out.println(hs.add(19));
        hs.add(0);
        System.out.println(hs);// 唯一且无序

        Map<String,Integer> map  = new HashMap<>();
        map.put("a",2);
        map.put("a",3);
        System.out.println(map);
    }
}
