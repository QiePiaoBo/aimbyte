package com.dylan.learnbasic.learniostream;

import java.io.*;

/**
 * @author Dylan
 * @Date : 2021/5/25 - 22:10
 * @Description :
 * @Function :
 */
public class Test16 {

    public static void main(String[] args) throws Exception{
        /**
         * 序列化和反序列化
         * ObjectOutputStream类，把内存中的java对象转换成平台无关的二进制数据，从而允许把这种二进制数据持久地保存在磁盘上
         * 或者通过网络将这种二进制数据传输到另一个网络节点 --->序列化
         * ObjectInputStream类，当其他程序获取了这种二进制数据，可以通过ObjectInputStream将其恢复成Java对象 --->反序列化
         */
        // 对象流 ObjectInputStream ObjectOutputStream
        // 用于存储和读取基本数据类型数据或对象的处理流，能够把java对象写入到数据源中，也能把对象从数据源中还原回来

        // 将一个字符串对象写入文件，我们看不懂文件的内容，但是程序能看懂
        //testObjectOutputStream();
        // 利用ObjectInputStream读文件
        testObjectInputStream();
    }

    private static void testObjectOutputStream() throws Exception{
        // 将内存的字符串写出到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("fileTestDir/test10/aim.txt")));
        oos.writeObject(new String("Hello world"));
        oos.close();
    }

    private static void testObjectInputStream() throws Exception{
        // 将文件中的内容读入到程序中
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(new File("fileTestDir/test10/aim.txt")));
        Object o = oin.readObject();
        System.out.println(o);
        oin.close();
    }
}
