package com.dylan.learnalgorithm.xinshou;

import javax.xml.stream.FactoryConfigurationError;
import java.util.SplittableRandom;

/**
 * @author Dylan
 * @Date : 2021/10/10 - 20:45
 * @Description :
 * @Function :
 */
public class Q07_halfDivide {

    /**
     * 查找数组中大于等于num的最靠左的位置
     * @param arr
     * @param num
     * @return
     */
    public static int mostLeftNoLessThanNum(int[] arr, int num){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R){
            int mid = (L + R) / 2;
            if (arr[mid] >= num){
                ans = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return ans;
    }


    /**
     * arr有序的情况下，查找arr中的num
     * @param arr
     * @param num
     * @return
     */
    public static boolean have(int[] arr, int num){
        if (arr == null || arr.length == 0){
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R){
            int mid = (L + R) / 2;
            if (arr[mid] == num){
                return true;
            }else if (arr[mid] < num){
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
