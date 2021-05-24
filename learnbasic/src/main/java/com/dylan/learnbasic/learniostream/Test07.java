package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Dylan
 * @Date : 2021/5/23 - 0:38
 * @Description :
 * @Function :
 */
public class Test07 {

    public static void main(String[] args) throws Exception {
        // 使用字节流将文件的内容读取到程序中来
        // 有一个源文件
        File source = new File("fileTestDir/test04/source.txt");
        File testOut = new File("fileTestDir/test04/out.txt");
        // 准备一个字节流作为管道怼到源文件上
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fot = new FileOutputStream(testOut);
        // 开始读取动作
        int n;
        while ((n = fis.read()) != -1){
            System.out.println(n);
            fot.write(n);
        }
        // 关闭流
        fot.close();
        fis.close();
    }
}
