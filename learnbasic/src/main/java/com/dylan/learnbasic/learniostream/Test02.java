package com.dylan.learnbasic.learniostream;

import java.io.File;

/**
 * @author Dylan
 * @Date : 2021/5/22 - 11:26
 * @Description : 对目录的操作
 * @Function :
 */
public class Test02 {
    public static void main(String[] args) {
        // 将目录封装为File类的对象
        File f = new File("fileTestDir/");
        // 常用方法
        System.out.println("文件是否可读：" + f.canRead());
        System.out.println("文件是否可写：" + f.canWrite());
        System.out.println("文件的名字：" + f.getName());
        System.out.println("文件上级目录：" + f.getParent());
        System.out.println("是否是目录：" + f.isDirectory());
        System.out.println("是否是文件：" + f.isFile());
        System.out.println("是否隐藏：" + f.isHidden());
        System.out.println("文件的大小：" + f.length());
        System.out.println("文件是否存在" + f.exists());
        System.out.println(f == f); // 比较两个对象的地址
        System.out.println(f.equals(f)); // 比较两个文件的路径
        // 路径相关
        System.out.println("绝对路径: " + f.getAbsoluteFile());
        System.out.println("相对路径: " + f.getPath());
        System.out.println("toString: " + f.toString());

        // 目录相关的方法
        // 创建目录1 只能创建单层目录
        if (!f.exists()){
            f.mkdir();
        }
        // 创建目录2 可以创建多级目录
        File f1 = new File("fileTestDir/test01/test");
        if (!f1.exists()){
            f1.mkdirs();
        }

        // 删除目录:如果删除目录的话，只能删除一层，而且这个目录必须是空的，如果不是空的就删不掉
        f1.delete();

        // 查看
        String[] list = f.list();
        System.out.println("文件夹下目录、文件对应的名字的数组");
        for (String s : list){
            System.out.println(s);
        }
        File[] files = f.listFiles();
        System.out.println("文件夹下目录、文件对应的数组，作用更加广泛");
        for (File lf : files){
            System.out.println("FileName: " + lf.getName() + ", FileAbsPath: " + lf.getAbsolutePath());
        }
    }
}
