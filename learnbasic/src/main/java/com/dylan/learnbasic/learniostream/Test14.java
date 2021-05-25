package com.dylan.learnbasic.learniostream;

import java.io.*;

/**
 * @author Dylan
 * @Date : 2021/5/25 - 21:16
 * @Description :
 * @Function :
 */
public class Test14 {

    public static void main(String[] args) throws Exception{

        /**
         * //// 键盘输入的内容写入到文件
         * 思路：
         * 键盘-->字节流-->转换流-->字符流-->程序-->字符流-->缓冲字符流-->文本文档
         */
        // 键盘与程序之间的管道,字节管道
        InputStream in = System.in;
        // 字节流转成字符流
        InputStreamReader trans1 = new InputStreamReader(in);
        // 为字符输入流做缓冲处理
        BufferedReader bIn = new BufferedReader(trans1);

        // 准备文件
        File aimFile = new File("fileTestDir/test08/aim.txt");
        // 为文件准备输出流
        FileWriter fileWriter = new FileWriter(aimFile);
        // 为输出流做缓冲处理
        BufferedWriter fout = new BufferedWriter(fileWriter);

        String s;
        while (!(s = bIn.readLine()).equals("exit")){
            fout.write(s);
            fout.newLine();
        }
        // 关闭流
        fout.close();
        bIn.close();
    }
}
