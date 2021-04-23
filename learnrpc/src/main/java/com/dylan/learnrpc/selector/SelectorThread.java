package com.dylan.learnrpc.selector;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Dylan
 * @Date : 2021/4/21 - 20:11
 * @Description :
 * @Function :
 */
public class SelectorThread implements Runnable{

    // 每线程对应一个selector，多线程清苦昂下，该程序的并发客户端被分配到多个selector上
    // 注意每个客户端只绑定到其中一个selector上，不会有交互问题


    Selector selector = null;

    LinkedBlockingQueue<Channel> lbq = new LinkedBlockingQueue<>();

    SelectorThreadGroup stg;
    public SelectorThread(SelectorThreadGroup stg) {
        try {
            this.stg = stg;
            selector = Selector.open();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // Loop
        while (true){
            try {
                System.out.println(Thread.currentThread().getName() + "before select......" + selector.keys().size());
                // 阻塞,设置超时事件可以解决阻塞,不设置反而可能会永久阻塞
                // 在selector中存在wakeup(),如果在其他线程中调用了wakeup，那么即便在这里是阻塞状态，也能够跳出来，当然得到的结果也不会大于0
                int nums = selector.select();
                // Thread.sleep(1000); // 线程睡眠绝不是解决方案
                System.out.println(Thread.currentThread().getName() + "after select......" + selector.keys().size());
                // 处理selectKeys
                if (nums > 0){
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = keys.iterator();
                    // 使用迭代器，selectionKey的处理过程是线性的
                   while (iter.hasNext()){
                        SelectionKey key = iter.next();
                        iter.remove();
                        if (key.isAcceptable()){    // 接收客户端的过程比较复杂，因为接收之后要注册，如果在多线程情况下，那么新客户端要注册到哪个selector里去呢
                            acceptHander(key);
                        }else if (key.isReadable()){
                            readHandler(key);
                        }else if (key.isWritable()){

                        }
                    }
                }
                // 当程序的select()结果不大于0即其他线程通过wakeup将传入channel并将select的阻塞状态打破时，会执行以下代码：
                if (!lbq.isEmpty()){
                    Channel channel = lbq.take();
                    if (channel instanceof ServerSocketChannel){
                        ServerSocketChannel s = (ServerSocketChannel) channel;
                        s.register(selector, SelectionKey.OP_ACCEPT);
                    }else if (channel instanceof SocketChannel){
                        SocketChannel c = (SocketChannel) channel;
                        ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
                        c.register(selector, SelectionKey.OP_READ, buffer);
                    }
                }
            }catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    private void readHandler(SelectionKey key) {
        ByteBuffer buffer = (ByteBuffer)key.attachment();
        SocketChannel client = (SocketChannel) key.channel();
        buffer.clear();
        while (true){
            try {
                int num = client.read(buffer);
                if (num > 0){
                    buffer.flip();  // 将读到的东西反转然后直接写出
                    while (buffer.hasRemaining()){client.write(buffer);}
                    buffer.clear();
                }else if (num == 0){
                    break;
                }else if(num < 0){
                    // 客户端断开或异常
                    System.out.println("Client : " + client.getRemoteAddress() + " closed...");
                    key.cancel();
                    break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    private void acceptHander(SelectionKey key) {
        System.out.println(Thread.currentThread().getName() + ": acceptHandler......");
        ServerSocketChannel server = (ServerSocketChannel)key.channel();
        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            // todo: 需要选择一个多路复用器去注册
            stg.nextSelector(client);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
