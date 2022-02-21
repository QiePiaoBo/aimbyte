package com.dylan.dychat.utils;

/**
 * @Classname PrintUtil
 * @Description 打印相关的Util
 * @Date 2022/2/19 17:51
 */
public class PrintUtil {

    public static void printInfo(String frame, Object... unit){
        String info = String.format("Info: threadId : %d, data : ", Thread.currentThread().getId());
        String format = String.format(frame, unit);
        System.out.println(info + format);
    }

    public static void printError(String frame, Object... unit){
        String error = String.format("Error: threadId : %d, data : ", Thread.currentThread().getId());
        String format = String.format(frame, unit);
        System.out.println(error + format);
    }
}
