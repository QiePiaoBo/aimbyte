package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Dylan
 * @Date : 2021/5/22 - 19:14
 * @Description :
 * @Function :
 */
public class Test05 {

    public static void main(String[] args) throws Exception{
        File source = new File("fileTestDir/test03/source.txt");
        File aim = new File("fileTestDir/test03/aim.txt");

        FileReader fr = new FileReader(source);
        FileWriter fw = new FileWriter(aim, true);

        // 方式1
        // copy1(fr, fw);
        // 方式2
        copy2(fr, fw);
        // 流的关闭要后用先关
        fw.close();
        fr.close();
    }

    /**
     * 方式1 一个一个字符进行复制
     * @param fr
     * @param fw
     * @throws Exception
     */
    public static void copy1(FileReader fr, FileWriter fw) throws Exception{
        int n = fr.read();
        while (n != -1){
            fw.write(n);
            n = fr.read();
        }
    }

    /**
     * 方式2利用缓冲区，一批一批进行复制
     * @param fr
     * @param fw
     * @throws Exception
     */
    public static void copy2(FileReader fr, FileWriter fw) throws Exception{
        char[] buffer = new char[10];
        int len;
        while ((len = fr.read(buffer)) != -1){
            fw.write(buffer, 0, len);
        }
    }

    /**
     * 方式2利用缓冲区，将一段缓冲区的元素转化为字符串写入
     * @param fr
     * @param fw
     * @throws Exception
     */
    public static void copy3(FileReader fr, FileWriter fw) throws Exception{
        char[] buffer = new char[10];
        int len;
        while ((len = fr.read(buffer)) != -1){
            String s = new String(buffer, 0, len);
            fw.write(s);
        }
    }
}
