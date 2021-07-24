package com.dylan.learnrpc.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dylan
 * @Date : 2021/4/21 - 20:05
 * @Description :
 * @Function :
 */
public class SelectorThreadGroup {

    SelectorThread[] sts;

    ServerSocketChannel server;

    // 线程安全的
    AtomicInteger xid = new AtomicInteger(0);

    SelectorThreadGroup stg = this;

    public void setWorker(SelectorThreadGroup stg){
        this.stg = stg;
    }

    SelectorThreadGroup(int num){
        // num : 线程数
        sts = new SelectorThread[num];
        for (int i = 0; i < num; i++) {
            sts[i] = new SelectorThread(this);
            new Thread(sts[i]).start();
        }
    }

    public void bind(int port){

        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            // server注册到哪个selector上呢
            nextSelector(server);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 无论是serverSocket还是socket都可以用这个方法找到属于自己的selector
    public void nextSelector(Channel channel) {

        // 找到自己的天选selectorThread
        SelectorThread st = next();
        // 将channel传入thread的队列中
        st.lbq.add(channel);
        // 对方一定会在select时阻塞，需要打断其阻塞状态，让对应的线程去自己在打断后完成注册selector
        st.selector.wakeup();



//        // channel可能是server，可能是client
//        ServerSocketChannel s = (ServerSocketChannel) channel;
//        try {
//            s.register(st.selector, SelectionKey.OP_ACCEPT);
//            st.selector.wakeup();   // 功能是让selector的select()方法立刻返回 不阻塞
//            System.out.println("aaaa");
//        } catch (ClosedChannelException e) {
//            e.printStackTrace();
//        }

    }


    private SelectorThread next() {
        int index = xid.incrementAndGet() % stg.sts.length;
        return stg.sts[index];
    }


}
