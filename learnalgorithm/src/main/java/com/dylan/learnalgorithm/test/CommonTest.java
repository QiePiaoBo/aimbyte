package com.dylan.learnalgorithm.test;
/**
 * @author Dylan
 * @Date : 2021/10/10 - 21:11
 * @Description :
 * @Function :
 */
public class CommonTest {
    /**
     * 对数器 生成随机样本自己做比对的机器
     * 生成随即长度随机大小的数组的
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue){
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int)(Math.random() * maxValue);
        }
        return ans;
    }
}
