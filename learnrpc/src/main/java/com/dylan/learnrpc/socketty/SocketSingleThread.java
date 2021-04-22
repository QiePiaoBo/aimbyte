package com.dylan.learnrpc.socketty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/**
 * @author Dylan
 * @Date : Created in 11:15 2021/4/21
 * @Description :
 * @Function :
 */
public class SocketSingleThread {

    private ServerSocketChannel server = null;
    private Selector selector = null;
    int port = 9090;

    public void initServer(){

        try {
            // 开启serverSocket
            server = ServerSocketChannel.open();
            // 将serverSocket设置为非阻塞模式，底层其实是设置的操作系统的NonBlocking属性
            server.configureBlocking(false);
            // 将serverSocket绑定到本机的某个端口上
            server.bind(new InetSocketAddress(port));
            /**
             *  如果使用的是select/poll模型
             *  如果使用的是epoll模型 则在open时会调用底层的epoll_create函数
             */
            selector = Selector.open();

            /**
             * server对应的是一个文件描述符 fd4
             * 如果使用的是select/poll模型，会在jvm开辟一个数组将 fd4 放到数组中
             * 如果使用的是epoll模型，会调用epoll_ctl( 将 fd4 的ACCEPT事件 加入红黑树管理起来
             */
            server.register(selector, SelectionKey.OP_ACCEPT);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        initServer();

        System.out.println("启动服务。。。");

        try {
            Set<SelectionKey> keys = selector.keys();
            System.out.println("size : " + keys.size());

            /**
             * select()做了什么？
             * 在select模型下：select(fd4,......)调用内核的select函数传入各种事件，对连接进行轮询，返回有状态的结果集
             * 在poll模型下：poll(fd4,......)调用内核的poll函数传入各种事件，对连接进行轮询，返回有状态的结果集
             * 在epoll模型下：调用内核的epoll_wait函数，取出结果集
             */
            while (selector.select() > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectionKeys.iterator();

                while (iter.hasNext()){
                    SelectionKey key = iter.next();

                    iter.remove();

                    if (key.isAcceptable()){
                        acceptHandler(key);
                    }else if (key.isReadable()){
                        readHandler(key);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void acceptHandler(SelectionKey key){
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocateDirect(8192);

            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("-------------------------------");
            System.out.println("新客户端：" + client.getRemoteAddress());
            System.out.println("-------------------------------");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readHandler(SelectionKey key){
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;

        try {
            while (true){
                read = client.read(buffer);
                if (read > 0){
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        client.write(buffer);
                    }
                    buffer.clear();
                }else if(read == 0){
                    break;
                }else {
                    client.close();
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketSingleThread server = new SocketSingleThread();
        server.start();
    }
}
