package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Dylan
 * @Date : 2021/5/22 - 14:30
 * @Description :
 * @Function :
 */
public class Test04 {

    public static void main(String[] args) throws IOException {
        // 二、文件内容->FileWriter->目标文件
        // 一个一个字符向外输出、n个字符n个字符向外输出
        // 目标文件
        File f = new File("fileTestDir/test02/demo.txt");
        // FileWriter 只在初始化FileWriter是传一个File对象，那么默认会覆盖源文件，添加一个true作为append参数的值，就不会覆盖了
        FileWriter fw = new FileWriter(f, true);
        // 输出
        String str = "你好中国";
        // 每次写入一个字符
        /*for (int i = 0; i < str.length(); i++) {
            fw.write(str.charAt(i));
        }*/
        // 一次写入整个字符串
        char[] chars = str.toCharArray();
        fw.write(chars);
        // 关闭流
        fw.close();
        // 如果目标文件不存在 那么会自动创建文件
        // 如果目标文件存在，那么会覆盖
    }
}
