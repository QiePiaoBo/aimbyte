package com.dylan.learnbasic.learnjvm;

/**
 * @author Dylan
 * @Date : 2021/10/11 - 16:31
 * @Description : 测试几种执行模式的快慢
 * @Function :
 */
public class TestModeSpeed {

    // 时间记录
    // -Xmixed 混合模式     2178
    // -Xint 纯解释模式      60450
    // -Xcomp 纯编译模式     2188

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            m();
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);
    }

    public static void m(){
        for (int i = 0; i < 10_0000L; i++) {
            long j = i % 3;
        }
    }
}
