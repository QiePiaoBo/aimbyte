package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Dylan
 * @Date : 2021/5/22 - 12:46
 * @Description :
 * @Function :
 */
public class Test03 {

    public static void main(String[] args) throws Exception {
        // 通过java程序完成文件的复制
        // 一、文件->FileReader->程序
        // 1. 创建对象
        File f = new File("fileTestDir/test01/fileTest.txt");
        // 2. 创建FileReader的流的对象
        FileReader fr = new FileReader(f);
        // 3. 读取动作
        // read()方法一次只能读一个字符，如果读到了就能获取到这个字符的unicode码（可以使用char强转成字符类型），如果没读到，就会返回-1
        /*int n = fr.read();
        System.out.println(n);*/
        // 读取全部内容的方式1
        /*int n = fr.read();
        while (n != -1){
            System.out.println(n);
            n = fr.read();
        }*/
        // 读取全部内容的方式2
        /*int n;
        while ((n = fr.read()) != -1){
            System.out.println((char)n);
        }*/
        // 一次性读取n个字符，如果不够的话，下次再读n个
        char[] ch = new char[5]; // 缓冲数组
        int len = fr.read(ch);// 一次读取5个字符,返回值是这个数组中的有效长度
        while (len != -1){
            // System.out.println(len);
            // 错误的方式,遍历全量的数组可能会得到数组中未被消费的元素
            /*for (int i = 0; i < ch.length; i++) {
                System.out.println(ch[i]);
            }*/
            // 正确的方式1，只需要遍历当前数组中有效的长度就可以了
            /*for (int i = 0; i < len; i++) {
                System.out.println(ch[i]);
            }*/
            // 正确的方式2，将数组中当前次数的有效长度转化为字符串
            System.out.println(new String(ch,0, len));
            len = fr.read(ch);
        }
        // 4. 关闭流 PS: jvm本身没法帮我们自动关闭流，必须手动关闭
        fr.close();
    }
}
