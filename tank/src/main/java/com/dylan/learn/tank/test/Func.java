package com.dylan.learn.tank.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Dylan
 * @Date : Created in 13:15 2021/4/20
 * @Description :
 * @Function :
 */
public class Func {
    public static void main(String[] args) {
        User user = new User();
        user.setName("asd");
        Map<String, String> aim = new HashMap();
        aim.put("name", "Dylan");
        aim.put("phone", "");
        BeanUtil.copyProperties(aim, user);

        System.out.println(asd1(user.getPhone()));

        String s1 = "[{\"key\":\"asd\", \"value\":\"aaaa\"},{\"key\":\"asd\", \"value\":\"aaaa\"},{\"key\":\"asd\", \"value\":\"aaaa\"}]";
        String s2 = s1.substring(1, s1.length() -1).replaceAll(" ", "");
        System.out.println(s2);
        String s3 = s2.replaceAll("},", "}&");
        String[] s4 = s3.split("&");
        for (String s : s4){
            JSONObject s5 = new JSONObject(s);
            System.out.println(s5.get("key"));
            break;
        }
        System.out.println("aaaqqqq");
    }

    public static String asd(String name){
        return null == name ? "yes" : "no";
    }

    public static String asd1(Long age){
        return null == age ? "yes" : "no";
    }
}
