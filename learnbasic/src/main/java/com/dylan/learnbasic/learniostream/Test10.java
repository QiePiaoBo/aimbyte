package com.dylan.learnbasic.learniostream;

import java.io.*;

/**
 * @author Dylan
 * @Date : Created in 13:12 2021/5/25
 * @Description :
 * @Function :
 */
public class Test10 {
    public static void main(String[] args) throws Exception{
        // 利用缓冲字符流（处理流）完成文本文件的复制
        File source = new File("fileTestDir/test06/source.txt");
        File aim = new File("fileTestDir/test06/aim.txt");

        FileReader reader = new FileReader(source);
        FileWriter writer = new FileWriter(aim);

        BufferedReader br = new BufferedReader(reader);
        BufferedWriter bw = new BufferedWriter(writer);

        // 方式1 一个字符一个字符地读写
//        int n;
//        while((n = br.read()) != -1){
//            bw.write((char) n);
//        }
        // 方式2 一个缓冲区一个缓冲区地读写
//        char[] buffer = new char[1024];
//        int n;
//        while ((n = br.read(buffer)) != -1){
//            bw.write(buffer, 0, n);
//        }
        // 方式3 一行一行地读写
        String str;
        while (null != (str = br.readLine())){
            bw.write(str);
            // 在文本文件中使用这种方式复制需要换行
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
