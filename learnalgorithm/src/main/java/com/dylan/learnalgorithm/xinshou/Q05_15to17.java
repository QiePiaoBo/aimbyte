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
     * 0 1 等概率返回
     * @return
     */
    public static int f01(){
        int ans = 0;
        do {
            ans = f5();
        }while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    public static int f7(){
        return 0;
    }
    public static void main(String[] args) {

        int testTime = 1000000;
        int[] arr = new int[7];
        int count = 0;
        for (int i = 0; i < testTime; i++) {
            if (f01() == 0){
                count ++;
            }
//            int res = f5();
//            arr[res]  ++;
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i + " : " + arr[i]);
//        }
        System.out.println((double) count / (double) testTime);
    }
}