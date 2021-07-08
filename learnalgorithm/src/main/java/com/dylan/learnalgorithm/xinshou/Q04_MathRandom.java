package com.dylan.learnalgorithm.xinshou;

import java.util.Map;

/**
 * @author Dylan
 * @Date : Created in 12:34 2021/7/7
 * @Description :
 * @Function :
 */
public class Q04_MathRandom {

    /**
     * 测试结果在[0-1)之间等概率
     */
    public static void testRandom01(){

        int testTimes = 1000000;
        int count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75){
                count ++;
            }
        }
        System.out.println((double) count / testTimes);
    }

    /**
     * 测试[0-n)之间等概率
     */
    public static void testRandom02(){
        int testTimes = 1000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if ((Math.random()*8) < 4){
                count ++;
            }
        }
        System.out.println((double) count/testTimes);
    }

    /**
     * 返回[0-k)上某一个整数
     */
    public static void testRandom03(){
        int k = 10;
        int testTimes = 1000000;
        int[] counts = new int[10];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int)(Math.random() * k);
            counts[ans] ++;
        }
        for(int j = 0; j < k; j ++){
            System.out.println(j + " : " + counts[j]);
        }
    }

    public static void testRandom04(){
        int testTimes = 1000000;
        int count = 0;
        double k = 0.5;
        for (int i = 0; i < testTimes; i++) {
            double v = x2XPower2();
            if (v < k){
                count ++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(k, 2));
//        System.out.println((double) 1 -  Math.pow((double)(1 - k), 2));
    }

    /**
     * 返回[0,1)的小数
     * 任意的x， x属于[0,1)出现概率由原来的x调整为x^2 x^3
     *
     * @return
     */
    public static double x2XPower2(){
        return Math.max(Math.random(), Math.random());
//        return Math.min(Math.random(), Math.random());
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        // testRandom01();
        // testRandom02();
        // testRandom03();
        testRandom04();
    }

}
