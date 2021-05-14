package com.dylan.learnthread.basic;

/**
 * @author Dylan
 * @Date : 2021/5/12 - 22:47
 * @Description : 数组排序, 数组是数据结构的一种实现，很多数据在存储的时候需要使用数组
 * @Function : 面试常见需求:写出某种排序算法（冒泡、选择、插入、快速）、排序算法的时间复杂度（衡量一个数据结构是否合适的衡量标准）、排序算法的稳定性
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] array = new int[]{0, 4, 1, 7, 2, 9, 3, 5, 8, 6};
        /* 冒泡
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]){
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        */

        // 选择
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

}
