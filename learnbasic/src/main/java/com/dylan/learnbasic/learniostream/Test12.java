package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Dylan
 * @Date : 2021/5/25 - 20:56
 * @Description :
 * @Function :
 */
public class Test12 {

    public static void main(String[] args) throws Exception{
        // System.in得到的是标准的输入流，从键盘输入
        // InputStream in = System.in;
        // 调用方法,read()方法会等待键盘的录入，所以这个方法是一个阻塞方法
        // int n = in.read();
        // System.out.println(n);

        // 从键盘录入一个int数据
        test01();
    }
    private static void test01() throws Exception{
        // System.in提供了键盘到程序的管道，从键盘录入时，录入的数据会进入到程序中
        // Scanner只是扫描了从键盘中出来到的内容
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
        // Scanner有扫描作用但不一定非得一定扫描System.in的管道
        Scanner sc1 = new Scanner(new FileInputStream(new File("fileTestDir/test01/fileTest.txt")));
        while (sc1.hasNext()) {
            System.out.println(sc1.next());
        }
    }
}
