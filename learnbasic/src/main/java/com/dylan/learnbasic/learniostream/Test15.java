package com.dylan.learnbasic.learniostream;

import java.io.*;

/**
 * @author Dylan
 * @Date : 2021/5/25 - 21:55
 * @Description :
 * @Function :
 */
public class Test15 {

    public static void main(String[] args) throws Exception{
        // 数据流：用来操作基本数据类型和字符串的
        // DataInputStream 将文件中存储的基本数据类型和字符串写入内存的变量中
        // DataOutputStream 将内存中的基本数据类型和字符串的变量写到文件中

        // DataOutputStream的使用,这种写法写出的内容是给程序看的，我们看不懂，程序能看懂
//        testDataOutputStream();
        // DataInputStream的使用，这种方式是利用程序去读
        testDataInputStream();
    }

    private static void testDataOutputStream() throws Exception {
        // DataOutputStream
//        File f = new File("fileTestDir/test09/DataOutputStream.txt");
//        FileOutputStream fos = new FileOutputStream(f);
//        DataOutputStream dos = new DataOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("fileTestDir/test09/DataOutputStream.txt")));

        dos.writeUTF("你好");
        dos.writeBoolean(false);
        dos.writeDouble(6.9);
        dos.writeInt(9999);

        // 关闭流
        dos.close();
    }

    private static void testDataInputStream() throws Exception{
        DataInputStream dis = new DataInputStream(new FileInputStream(new File("fileTestDir/test09/DataOutputStream.txt")));
        // 将文件中的内容读到程序中
        System.out.println(dis.readUTF());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readDouble());
        System.out.println(dis.readInt());
        dis.close();
    }
}
