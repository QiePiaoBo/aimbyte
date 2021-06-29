package com.dylan.learnalgorithm.xinshou;

/**
 * @author Dylan
 * @Date : Created in 16:09 2021/6/28
 * @Description : 查询数组某一段的累加和，优化查询速度
 * @Function :
 */
public class Q03_BetterQuery {
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
     * 生成二维数组
     * @param arr
     * @return
     */
    public static int[][] computeLR1(int[] arr){
        int[][] res = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i > j){
                    res[i][j] = 0;
                }else {
                    res[i][j] = computeLR11(arr, i, j);
                }
            }
        }
        return res;
    }

    /**
     * 最笨的办法
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static int computeLR11(int[] arr, int i, int j) {
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += arr[k];
        }
        return res;
    }


    /**
     * 前缀和数组 左闭右闭
     * @param arr
     * @return
     */
    public static int[] computeLR2(int[] arr){
        int[] help = new int[arr.length];
        help[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            help[i] = help[i - 1] + arr[i];
        }
        return help;
    }
    
    
    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 5, 3, 7, 4, 6};
        printArray(arr);
        int[][] helpSquare = computeLR1(arr);
        int[] helpArray = computeLR2(arr);
        int left = 5, right = 7;
        System.out.println(helpSquare[left][right]);
        System.out.println(left == 0 ? helpArray[right] : helpArray[right] - helpArray[left - 1]);
        System.out.println(computeLR11(arr, left, right));
    }

}
