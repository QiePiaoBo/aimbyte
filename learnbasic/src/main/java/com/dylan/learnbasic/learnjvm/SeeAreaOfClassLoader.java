package com.dylan.learnbasic.learnjvm;

/**
 * @author Dylan
 * @Date : 2021/7/4 - 22:43
 * @Description : 打印各加载器的加载范围
 * @Function :
 */
public class SeeAreaOfClassLoader {

    public static void main(String[] args) {

        // Launcher类中定义了各个ClassLoader的读取范围
        // Boot sun.boot.class.path
        // Ext java.ext.dirs
        // App java.class.path
        System.out.println("------------------BootPath------------------");
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));


        System.out.println("------------------ExtPath------------------");
        String extBoot = System.getProperty("java.ext.dirs");
        System.out.println(extBoot.replaceAll(";", System.lineSeparator()));

        System.out.println("------------------AppPath------------------");
        String appBoot = System.getProperty("java.class.path");
        System.out.println(appBoot.replaceAll(";", System.lineSeparator()));


    }

}
