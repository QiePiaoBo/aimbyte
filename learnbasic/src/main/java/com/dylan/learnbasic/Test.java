package com.dylan.learnbasic;

import java.io.File;
import java.util.*;

/**
 * @author Dylan
 * @Date : Created in 11:01 2021/6/7
 * @Description :
 * @Function :
 */
public class Test {

    public static void main(String[] args) {
        testMap();
    }
    public static void testMap(){
        String s = null;
        System.out.println("asd.asd".replaceAll("\\.", ""));

        Map<String, String> testMap = new HashMap<>();
        System.out.println(testMap.get("a"));

        testMap.put("a", "A");
        testMap.put("b", "B");
        testMap.put("c", "C");
        System.out.println(testMap.toString());


        File file = new File("F:\\_TestDir");
        System.out.println(file.exists());
    }
}
