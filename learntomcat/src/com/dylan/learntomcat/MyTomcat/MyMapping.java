package com.dylan.learntomcat.MyTomcat;

import java.util.HashMap;

/**
 * @author Dylan
 * @Date : 2021/6/5 - 20:19
 * @Description :
 * @Function :
 */
public class MyMapping {

    public static HashMap<String,String> mapping = new HashMap<>();

    static {
        // 添加请求和处理类的映射关系
        mapping.put("/mytomcat", "com.dylan.learntomcat.MyTomcat.MyServlet");
    }

    public HashMap<String, String> getMapping(){
        return mapping;
    }

}
