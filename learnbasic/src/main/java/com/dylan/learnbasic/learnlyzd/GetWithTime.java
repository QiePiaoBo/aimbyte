package com.dylan.learnbasic.learnlyzd;

/**
 * @author Dylan
 * @Date : 2021/8/9 - 23:04
 * @Description :
 * @Function :
 */
public class GetWithTime {

    private static int base = 1886;
    private static boolean pay4Sleep = false;

    public static Integer computeMoneyWithTime(int months){

        for (int i = 0; i < months; i++) {

            if (pay4Sleep){
                base = base - 594;
                pay4Sleep = false;
            }else {
                base = base + 3394;
                pay4Sleep = true;
            }
        }

        return base;
    }


    public static void main(String[] args) {

        Integer res = computeMoneyWithTime(3);

        System.out.println(res);

    }
}