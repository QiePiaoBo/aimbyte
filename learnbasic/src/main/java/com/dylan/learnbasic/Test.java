package com.dylan.learnbasic;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

/**
 * @author Dylan
 * @Date : Created in 11:01 2021/6/7
 * @Description :
 * @Function :
 */
public class Test {

    public static void testMap() {
        String s = null;
        System.out.println("asd.asd".replaceAll("\\.", ""));

        Map<String, String> testMap = new HashMap<>();
        System.out.println(testMap.get("a"));

        testMap.put("a", "A");
        testMap.put("b", "B");
        testMap.put("c", "C");
        System.out.println(testMap.toString());


        File file = new File("F:\\_TestDir/aaa");
        System.out.println(file.exists());
        System.out.println(file.getParent());
    }

    public static void testSplit() {
        //        testMap();

        String a1 = "a/g/";
        System.out.println(a1.split("/")[1]);
        a1 = a1.substring(a1.lastIndexOf("/") + 1);
        System.out.println(a1);
    }

    public static void testJson() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "");


        System.out.println("".equals(jsonObject.get("a").toString()));
    }

    public static void main(String[] args) {

        // 遍历字符串每个元素转化成数字后的值
        String s = "aaa";
        IntStream chars = s.codePoints();
        PrimitiveIterator.OfInt iterator = chars.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.nextInt());
        }

        // int数组转化为字符串
        int[] ints = {97, 98, 999999999};
        String s1 = new String(ints, 0, 3);
        System.out.println(s1);
        PrintStream out = System.out;
    }

}