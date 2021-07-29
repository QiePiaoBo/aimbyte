package com.dylan.learnbasic;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

        String a1 = "a/g/aaa.txt";
        String a2 = "a/g/aaa.txt";
//        System.out.println(a1.split("/")[1]);
        a1 = a1.substring(a1.lastIndexOf("/") + 1);
        String a3 = a2.substring(0, a2.lastIndexOf("/") + 1);
        System.out.println(a1);
        System.out.println(a3);
    }

    private static void testString(){
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

    public static void testJson() throws IOException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "");


        System.out.println("".equals(jsonObject.get("a").toString()));

        //        String path = "C:\\Users\\Dylan\\Desktop\\动态首页启动页.json";
        String path = "C:\\Users\\Dylan\\Desktop\\jia.json";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        JSONObject json = JSON.parseObject(fis, StandardCharsets.UTF_8, JSONObject.class, Feature.OrderedField);
        System.out.println(null == json);
        JSONObject app01 = json.getJSONObject("app01");
        System.out.println("app01 is : " + app01);
        JSONArray startPages = app01.getJSONArray("startPages");
        System.out.println("StartPages is : " + startPages);
        JSONObject aim = startPages.getJSONObject(0);
        System.out.println("JsonObject 01 is : " + aim);
        Long id = aim.getLong("id");
        System.out.println("id is : "+ id);
    }


    public static void main(String[] args) throws IOException {
        Snowflake snowflake = IdUtil.createSnowflake(20, 1);

        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextId());


    }
}