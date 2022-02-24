package com.dylan.tomcat.tomcat.traditional;

import com.dylan.NettyLearnEnum;
import com.dylan.tomcat.GPServlet;

import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Classname GPTomcat
 * @Description TODO
 * @Date 2022/2/21 11:08
 */
public class GPTomcat {

    private int port = NettyLearnEnum.TOMCAT.getPort();
    private ServerSocket server;
    private Map<String, GPServlet> servletMapping = new HashMap<>();
    private Properties webxml = new Properties();

    private void init(){
        // 加载web.xml 同时初始化servletMapping对象
        try {
            String WEB_INF = this.getClass().getResource("../../../../../").getPath();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(GPTomcat.class.getResource("/").getPath());
    }
}
