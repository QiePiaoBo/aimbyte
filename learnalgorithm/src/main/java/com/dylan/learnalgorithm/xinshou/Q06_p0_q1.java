package com.dylan.learnalgorithm.xinshou;

/**
 * @author Dylan
 * @Date : 2021/10/10 - 19:49
 * @Description : 已知一个方法，以概率p返回0，概率1-p返回1，要求写出一个函数y使0 1 等概率返回
 * @Function :
 */
public class Q06_p0_q1 {

    // 你只能知道，x方法会固定概率返回0和1，但x的内容无法看到
    public static int x(){
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 等概率返回0和1
    public static int y(){
        int ans = 0;
        do {
            ans = x();
        }while (ans == x());
        // 0 1、1 0 时会跳出这个循环
        return ans;
    }
}