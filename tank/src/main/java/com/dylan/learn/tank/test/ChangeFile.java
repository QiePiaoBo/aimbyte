package com.dylan.learn.tank.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Dylan
 * @Date : Created in 8:38 2021/4/23
 * @Description :
 * @Function :
 */
public class ChangeFile {
    private static final Logger logger = LoggerFactory.getLogger(ChangeFile.class);

    public static void main(String[] args) {
        //获取要读取的文件
        File readFile=new File("C:\\Users\\Dylan\\Desktop\\bzdm.txt");
        //输入IO流声明
        InputStream in=null;
        InputStreamReader ir=null;
        BufferedReader br=null;

        try {
            //用流读取文件
            in=new BufferedInputStream(new FileInputStream(readFile));
            //如果你文件已utf-8编码的就按这个编码来读取，不然又中文会读取到乱码
            ir=new InputStreamReader(in, StandardCharsets.UTF_8);
            //字符输入流中读取文本,这样可以一行一行读取
            br= new BufferedReader(ir);
            String line="";

            //一行一行读取
            while((line=br.readLine())!=null){
                String line1 = line.replaceAll(" ", "");
                System.out.println(line1 + ",");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            //一定要关闭流,倒序关闭
            try {

                if(br!=null){
                    br.close();
                }
                if(ir!=null){
                    ir.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch (Exception e2) {

            }

        }
    }
}
