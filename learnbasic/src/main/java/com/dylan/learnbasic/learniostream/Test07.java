package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileInputStream;

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
        // 准备一个字节流作为管道怼到源文件上
        FileInputStream fis = new FileInputStream(source);
        // 开始读取动作
        int n = fis.read();
        while (n != -1){
            System.out.println(n);
            n = fis.read();
        }
        // 关闭流
        fis.close();
    }
}
