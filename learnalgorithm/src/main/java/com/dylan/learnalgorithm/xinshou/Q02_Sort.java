package com.dylan.learnalgorithm.xinshou;

import com.dylan.learnalgorithm.test.CommonTest;

/**
 * @author Dylan
 * @Date : 2021/6/26 - 18:47
 * @Description : 选择、冒泡排序
 * @Function :
 */
public class Q02_Sort {
    /**
     * 交换位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 选择排序
     * @param arr
     */
    public static  void selectSort(int[] arr){

        // 处理边界条件
        if (arr == null || arr.length < 2){
            return ;
         }
        int N  = arr.length;
        for (int i = 0; i < N; i++) {
            // i - N-1 范围上做操作
            int minValueIndex = i;
            // 选出最小值的位置
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            // 将i位置的数与最小值所在位置的数做交换
            swap(arr, i, minValueIndex);
        }
    }
    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        // 处理边界条件
        if (arr == null || arr.length < 2){
            return ;
        }
        int N = arr.length;
        for (int end = N - 1; end >= 0 ; end--) {
            // 0~end之间
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        // 处理边界条件
        if (arr == null || arr.length < 2){
            return ;
        }
        // 0~1有序
        // 0~2有序
        // 0~3有序
        // ...
        int N = arr.length;
        for (int end = 1; end < N; end ++){
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]){
                swap(arr, newNumIndex -1, newNumIndex);
                newNumIndex --;
            }
        }
    }


    /**
     * 拷贝数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 验证两个数组完全相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean equalValues(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 测试数组是按顺序排列的 bigger为true表示从小到大
     * @param arr
     * @return
     */
    public static boolean arrSorted(int[] arr, boolean bigger){
        if (arr.length < 2){
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i] && bigger){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        int maxLen = 50;
        int maxValue = 1000;
        int testTime = 10000;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CommonTest.lenRandomValueRandom(maxLen, maxValue);
            int[] arr2 = copyArray(arr1);
            selectSort(arr1);
            insertSort(arr2);
            if (!arrSorted(arr1, true)){
                for (int j = 0; j < arr1.length; j++) {
                    System.out.print(arr1[j] + " ");
                }
                System.out.println();
                System.out.println("选择排序错了");
                break;
            }
            if (!arrSorted(arr2, true)){
                for (int j = 0; j < arr2.length; j++) {
                    System.out.print(arr2[j] + " ");
                }
                System.out.println();
                System.out.println("插入排序错了");
                break;
            }
        }
    }
}