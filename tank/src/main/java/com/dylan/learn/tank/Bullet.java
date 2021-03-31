package com.dylan.learn.tank;

import java.awt.*;

/**
 * @author Dylan
 * @Date : 2021/3/31 - 22:42
 * @Description :
 * @Function :
 */
public class Bullet {

    private static final int SPEED = 5;

    private int x, y;
    private Dir dir;
    private static int WIDTH = 20, HEIGHT = 20;
    private TankFrame tankFrame;
    private boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if (!live){
            tankFrame.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
        switch (dir){
            case Down:
                y += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case Right:
                x += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }
    }
}
