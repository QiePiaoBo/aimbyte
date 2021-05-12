package com.dylan.learnthread.basic;

import java.util.Scanner;

/**
 * @author Dylan
 * @Date : 2021/5/12 - 14:58
 * @Description : 斐波那契数列
 * @Function :
 */
public class Num {

    public static void main(String[] args) {
        int x = 1 , y = 1;
        int z = 0;
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for (int i = 1; i < count; i++) {
            if (i < 3){
                System.out.println(1);;
            }else {
                z = x + y;
                x = y;
                y = z;
                System.out.println(z);
            }
        }
    }

}
