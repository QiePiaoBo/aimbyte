package com.dylan.learn.tank;

/**
 * @author Dylan
 * @Date : 2021/3/31 - 22:11
 * @Description :
 * @Function :
 */
public class Play {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }

}
