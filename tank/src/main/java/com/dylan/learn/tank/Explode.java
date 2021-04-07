package com.dylan.learn.tank;

import java.awt.*;

/**
 * @author Dylan
 * @Date : 2021/4/7 - 16:05
 * @Description :
 * @Function :
 */
public class Explode {

    public static int WIDTH = ResourceManager.explodes[0].getWidth();
    public static int HEIGHT = ResourceManager.explodes[1].getHeight();

    private int x, y;
    private boolean living = true;
    TankFrame tankFrame = null;

    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceManager.explodes[step ++], x, y, null);
        if (step >= ResourceManager.explodes.length){
            step = 0;
        }
    }
}
