package com.dylan.learnalgorithm.xinshou;

/**
 * @author Dylan
 * @Date : 2021/6/26 - 18:47
 * @Description : 选择、冒泡排序
 * @Function :
 */
public class Q02_SelectionSort {
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



    public static void main(String[] args) {

        int[] arr = {7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6};

        printArray(arr);

        /*selectSort(arr);*/
        /*bubbleSort(arr);*/
        insertSort(arr);
        printArray(arr);
    }



}
