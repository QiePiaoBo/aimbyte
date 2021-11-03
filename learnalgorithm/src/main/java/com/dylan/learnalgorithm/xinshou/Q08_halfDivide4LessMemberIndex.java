package com.dylan.learnalgorithm.xinshou;

/**
 * @author Dylan
 * @Date : Created in 1:39 2021/11/4
 * @Description : 求一个int数组的一个局部最小值的下标
 * @Function :
 */
public class Q08_halfDivide4LessMemberIndex {

    /**
     * 给定一个满足以下条件的数组：
     * 任意两个相邻的值不相等
     * 无序
     * 要求找出该数组中的一个局部最小值(该值小于其相邻的数值，第一个值和最后一个值符合条件也算)
     * @param arr
     * @return
     */
    public static int getOneLittleMemIndex(int[] arr) {
        int ans = -1;
        // 排除异常情况
        if (null == arr || arr.length == 0) {
            return -1;
        }
        // 边界条件
        if (arr.length == 1) {
            return 0;
        }
        if (arr.length == 2) {
            return (arr[0] < arr[1]) ? 0 : 1;
        }
        // 数组长度
        int length = arr.length;
        // 特殊情况
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[length - 1] < arr[length - 2]) {
            return length - 1;
        }
        // 普遍情况
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                if (arr[mid] < arr[mid - 1])
                    return mid;
                else
                    right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 生成相邻数不相等的随机数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getRightArr(int maxLength, int maxValue){
        int len = 0;
        do {
            len = (int) (Math.random() * maxLength);
        }while (len == 0);
        int[] arr = new int[len];
        // 从第一个元素开始随机，保证下一位与上一位不相等
        arr[0] = (int)(Math.random() * maxValue);
        for (int i = 1; i < len; i++) {
            do {
                arr[i] = (int)(Math.random() * maxValue);
            }while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    /**
     * 验证minIndex是arr的局部最小值
     * @param arr
     * @param minIndex
     * @return
     */
    public static boolean answerIsRight(int[] arr, int minIndex){
        if (arr.length == 0){
            return false;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;

        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right <= arr.length -1 ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    /**
     * 打印数组，用来查看错误情况
     * @param arr
     */
    public static void  printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        int[] arr = {8, 3, 2, 1, 3, 2, 9, 7, 8, 0, 10};
//        int minIndex = getOneLittleMemIndex(arr);
//        System.out.println(minIndex);
//        System.out.println(answerIsRight(arr, minIndex));

        // 测试次数
        int testTime = 10000000;
        // 测试数组的最大长度
        int maxLength = 10;
        int maxValue = 50;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int [] arr = getRightArr(maxLength, maxValue);
            int minIndex = getOneLittleMemIndex(arr);
            if (!answerIsRight(arr, minIndex)){
                printArray(arr);
                System.out.println("minIndex : " + minIndex);
            }
        }
        System.out.println("测试结束");
    }


}
