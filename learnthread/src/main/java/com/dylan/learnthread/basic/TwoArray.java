package com.dylan.learnthread.basic;

/**
 * @author Dylan
 * @Date : 2021/5/12 - 23:16
 * @Description : 二维数组可以称作数组的数组，定义二维数组必须要给定数组的长度
 * @Function :
 */
public class TwoArray {

    public static void main(String[] args) {
        int[] arr = new int[6];

        // 定义
        int[][] arr2 = new int[3][];
        arr2[0] = new int[1];
        arr2[1] = new int[2];
        arr2[2] = new int[3];
        // 赋值
        arr2[0][0] = 1;
        arr2[1][0] = 2;
        arr2[1][1] = 3;
        arr2[2][0] = 4;
        arr2[2][1] = 5;
        arr2[2][2] = 6;


        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
