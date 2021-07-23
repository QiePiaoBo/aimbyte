package com.dylan.learnalgorithm.xinshou;

/**
 * @author Dylan
 * @Date : Created in 16:22 2021/7/7
 * @Description :
 * @Function :
 */
public class Q05_15to17 {

    /**
     * 1-5等概率
     * @return
     */
    public static int f5(){
        return ((int)(Math.random() * 5)) + 1;
    }

    /**
     * 0 1 等概率返回，使用f5，将其所有等概率的结果均分到0和1上，如果有多余的一个返回值则不进行返回
     * @return
     */
    public static int f01(){
        int ans = 0;
        do {
            ans = f5();
        }while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 000-111即0-7等概率返回
     */
    public static int f000111(){
        int ans = (f01() << 2) + (f01() << 1) + (f01() << 0);
        return ans;
    }

    /**
     * 0-6等概率返回
     * @return
     */
    public static int f06(){
        int ans = 0;
        do {
            ans = f000111();
        }while (ans == 7);
        return ans;
    }


    /**
     * 1-7等概率返回
     * @return
     */
    public static int f17(){
        return f06() + 1;
    }
    public static void main(String[] args) {

        int testTime = 1000000;
        int[] counts = new int[9];
        for (int i = 0; i < testTime; i++) {
            int res = f17();
            counts[res]  ++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现的次数 : " + counts[i]);
        }
    }
}