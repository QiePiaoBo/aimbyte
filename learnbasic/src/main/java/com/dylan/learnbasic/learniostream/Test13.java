package com.dylan.learnbasic.learniostream;

import java.io.PrintStream;

/**
 * @author Dylan
 * @Date : 2021/5/25 - 21:11
 * @Description :
 * @Function :
 */
public class Test13 {
    public static void main(String[] args) {
        // System.out的返回值是一个输出流PrintStream，它可以在控制台上写出
        PrintStream out = System.out;
        // 直接输出到控制台，不换行
        out.print("hello ");
        // 直接输出到控制台，换行
        out.println("world");
        out.println("how are you");
    }
}
