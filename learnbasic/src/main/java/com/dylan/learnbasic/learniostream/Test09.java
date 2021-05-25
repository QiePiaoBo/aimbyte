package com.dylan.learnbasic.learniostream;

import java.io.*;

/**
 * @author Dylan
 * @Date : Created in 12:47 2021/5/25
 * @Description :
 * @Function :
 */
public class Test09 {

    public static void main(String[] args) throws Exception{
        // 利用缓冲区，FileInputStream和FileOutputStream无法做到利用缓冲区来减少与和硬盘的交互次数
        // 所以就有了BufferedInputStream和BufferedOutputStream——处理流、缓冲字节流，“管”套着“管”
        // 原图片、目标图片
        File source = new File("fileTestDir/test05/source.jpg");
        File aim = new File("fileTestDir/test05/aim.jpg");
        // 输入流输出流
        FileInputStream fin = new FileInputStream(source);
        FileOutputStream fout = new FileOutputStream(aim);
        // 功能加强、在输入流输出流之外再套一层
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(fout);

        byte[] buffer = new byte[1024*6];
        int n;
        while ((n = bin.read(buffer)) != -1){
            System.out.println(n);
            bout.write(buffer,0, n);
            // bout.flush(); BufferedOutputStream已经帮我们执行了flush操作，所以我们不用手动去flush
        }
        // 关闭流,倒着关
        // 如果处理流包裹着节点流的话，只要关闭高级些的处理流，那么里面的节点流也会随之会关闭
        bout.close();
        bin.close();
    }
}
