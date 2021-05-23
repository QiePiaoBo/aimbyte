package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Dylan
 * @Date : 2021/5/22 - 19:36
 * @Description :
 * @Function :
 */
public class Test06 {

    public static void main(String[] args) throws Exception {
        // 使用字节流将文件的内容读取到程序中来
        // 有一个源文件
        File source = new File("fileTestDir/test04/source.txt");
        // 准备一个字节流作为管道怼到源文件上
        FileInputStream fis = new FileInputStream(source);
        // 开始读取动作
        /*
        * 1.文件是utf-8进行存储的，所以英文字符底层实际占用1字节 中文字符 底层其实占3字节
        * 2.如果文件是文本文件 那么就不要使用字节流进行读取了，可以使用字符流
        * 3.read()读取一个字节，但是返回值是int类型，而不是byte类型
        * 4.read方法底层做了处理，让返回的数据都是”正数“，是为了避免如果字节返回的是-1的话，那到底是读入的字节还是读到了文件结尾呢
        * */
        int n = fis.read();
        while (n != -1){
            System.out.println(n);
            n = fis.read();
        }
        // 关闭流
        fis.close();
    }

}
