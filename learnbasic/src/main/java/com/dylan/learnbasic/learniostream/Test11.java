package com.dylan.learnbasic.learniostream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Dylan
 * @Date : Created in 13:37 2021/5/25
 * @Description :
 * @Function :
 */
public class Test11 {

    public static void main(String[] args) throws Exception{
        // 转换流 将字节流和字符流进行转换
        // InputStreamReader OutputStreamWriter 这两者都属于字符流，通过后缀判断
        // 转换过程：
        // InputStreamReader : 字节输入流-》字符输入流
        // OutputStreamWriter : 字符输出流-》字节输出流

        File source = new File("fileTestDir/test07/source.txt");
        File aim = new File("fileTestDir/test07/aim.txt");

        // 字节输入流与字节输出流
        FileInputStream fin = new FileInputStream(source);
        FileOutputStream fout = new FileOutputStream(aim);

        // 转换流，字节转换为字符的时候需要指定一个编码格式，这个编码格式要和文件本身的相同
        // 如果编码格式不统一，那么在控制台上展示的效果就会出现乱码
        // 如果不向其构造器中传入编码格式，会自动获取当前程序的编码格式作为默认值
        InputStreamReader inR = new InputStreamReader(fin, StandardCharsets.UTF_8);

        OutputStreamWriter outW = new OutputStreamWriter(fout, StandardCharsets.UTF_8);

        char[] ch = new char[20];
        int read;
        while((read = inR.read(ch)) != -1){
            System.out.println(new String(ch, 0, read));
            outW.write(ch, 0, read);
        }
        outW.close();
        inR.close();
    }
}