package com.dylan.learnsocket.s01;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.management.ThreadInfo;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dylan
 * @Date : 2021/11/3 - 1:46
 * @Description :
 * @Function :
 */
public class CommonClient {

    public static Socket getSocket(String host, Integer port) throws IOException {
        return new Socket(host, port);
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(3);
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger atomicInteger = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread4CommonClient_" + atomicInteger.getAndIncrement());
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 12, 1000, TimeUnit.SECONDS, blockingQueue, threadFactory);

        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Socket socket = getSocket("localhost", 9090);
                    writeSthToServerSocket(socket, "Hello World.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        stopSocketServerInOneSecond();
        threadPoolExecutor.shutdown();
    }


    private static void stopSocketServerInOneSecond() {
        try {
            Thread.sleep(1000);
            Socket socket = getSocket("localhost", 9090);
            writeSthToServerSocket(socket, "Bye");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeSthToServerSocket(Socket socket, String s) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            int length = s.getBytes().length;
            objectOutputStream.writeInt(length);
            objectOutputStream.flush();
            objectOutputStream.write(s.getBytes());
            objectOutputStream.flush();
            objectOutputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
