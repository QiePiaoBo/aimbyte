package com.dylan.learntomcat.MyTomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dylan
 * @Date : 2021/6/5 - 20:30
 * @Description :
 * @Function :
 */
public class MyServer {

    /**
     * 用来定义服务端的接收程序，接收socket请求
     * @param port
     */
    public static void StartServer(int port) throws Exception {

        // 定义服务端套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 定义客户端套接字
        Socket socket = null;
        while (true){
            socket = serverSocket.accept();
            // 获取输入流和输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            // 定义请求、响应对象
            MyRequest request = new MyRequest(inputStream);
            MyResponse response = new MyResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if (clazz != null){
                Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
                // 根据MyServletClass创建对象
                MyServlet servlet = myServletClass.newInstance();
                // 使用servlet对象去处理请求
                servlet.service(request, response);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        StartServer(9999);
    }

}