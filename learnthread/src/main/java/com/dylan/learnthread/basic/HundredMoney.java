package com.dylan.learnthread.basic;

/**
 * @author Dylan
 * @Date : 2021/5/12 - 17:17
 * @Description : 百钱买百鸡
 * @Function :
 */
public class HundredMoney {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 34; j++) {
                for (int k = 0; k < 300; k++) {
                    if ((i + j + k) == 100 && ((5*i+3*j+k/3) == 100) && (k%3 == 0)){
                        System.out.println("公鸡：" + i + " 母鸡："  + j + " 小鸡：" + k);
                    }
                }
            }
        }
    }

}
