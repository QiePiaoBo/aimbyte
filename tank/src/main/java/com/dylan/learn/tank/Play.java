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

        // 初始化敌方坦克
        for (int i = 0; i < 5; i ++){
            tankFrame.bosses.add(new Tank(50 + i*80, 200, Dir.Down, tankFrame));
        }

        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }

}
