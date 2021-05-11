package com.dylan.learnthread.prodcons;

/**
 * @author Dylan
 * @Date : Created in 13:40 2021/5/11
 * @Description :
 * @Function :
 */
public class SleepUtil {

    public static void sleep(Integer timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
