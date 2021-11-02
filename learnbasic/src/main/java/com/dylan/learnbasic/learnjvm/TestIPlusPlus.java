package com.dylan.learnbasic.learnjvm;

/**
 * @author Dylan
 * @Date : 2021/10/13 - 17:11
 * @Description :
 * @Function :
 */
public class TestIPlusPlus {

    public static void main(String[] args) {
        int o = 66666;
        int i = 8;
//        i = i ++;
        i = ++i;
        System.out.println(i);
    }

    private int m1(){
        return 100;
    }
}