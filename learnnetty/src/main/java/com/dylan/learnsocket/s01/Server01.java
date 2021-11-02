package com.dylan.learnsocket.s01;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dylan
 * @Date : 2021/11/3 - 1:46
 * @Description :
 * @Function :
 */
public class Server01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9090, 5, InetAddress.getByName("localhost"));
            serverSocket.setSoTimeout(1000 * 60 * 60);
            System.out.println(serverSocket.getInetAddress());
            System.out.println(serverSocket.getSoTimeout());

            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                int length = objectInputStream.readInt();
                byte[] bytes = new byte[length];
                objectInputStream.readFully(bytes);
                String info = new String(bytes);
                System.out.println(info);
                objectInputStream.close();
                inputStream.close();
                socket.close();
                if ("Bye".equals(info)){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
