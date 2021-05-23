package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.IOException;

/**
 * @author Dylan
 * @Date : 2021/5/22 - 10:57
 * @Description :
 * @Function :
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        // 将文件封装为File的对象
        String basicPath = "G:/Java/Msb/aimbyte/learnbasic/src/main/resources";
        // File.separator帮我们获取当前操作系统的路径拼接符号
        File file = new File(basicPath + File.separator + "test.txt");
        File file1 = new File(basicPath + File.separator + "test.txt");
        // 常用方法
        System.out.println("文件是否可读：" + file.canRead());
        System.out.println("文件是否可写：" + file.canWrite());
        System.out.println("文件的名字：" + file.getName());
        System.out.println("文件上级目录：" + file.getParent());
        System.out.println("是否是目录：" + file.isDirectory());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("是否隐藏：" + file.isHidden());
        System.out.println("文件的大小：" + file.length());
        System.out.println("文件是否存在" + file.exists());
        /**
        if (file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }
        */
        System.out.println(file == file1); // 比较两个对象的地址
        System.out.println(file.equals(file1)); // 比较两个文件的路径
        // 路径相关
        System.out.println("绝对路径: " + file.getAbsoluteFile());
        System.out.println("相对路径: " + file.getPath());
        System.out.println("toString: " + file.toString());

        File file2 = new File("fileTest.txt");
        if (!file2.exists()){
            file2.createNewFile();
        }
        // 绝对路径：一个真实的完整的精准的路径
        System.out.println("绝对路径: " + file2.getAbsoluteFile());
        // 相对路径：有参照物，相对于参照物的路径
        // 在main方法中，相对位置指的就是当前的工作目录
        System.out.println("相对路径: " + file2.getPath());
        System.out.println("toString: " + file2.toString());
    }
}
