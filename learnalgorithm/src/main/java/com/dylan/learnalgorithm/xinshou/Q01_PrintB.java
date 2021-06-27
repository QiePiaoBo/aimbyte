package com.dylan.learnalgorithm.xinshou;

/**
 * @author Dylan
 * @Date : 2021/6/25 - 19:46
 * @Description :
 * @Function :
 */
public class Q01_PrintB {

    /**
     * 打印num的32位
     * @param num
     */
    public static void print(int num){
        for (int i = 31; i >=0; i --){
            System.out.print(  (num & (1 << i)) == 0 ? "0":"1" );
        }
    }

    public static void main(String[] args) {
        int num = 487512992;
        print(num);

        System.out.println("");
        int zero = 0;
        print(~zero + 1);

    }


}
