package com.dylan.learn.tank;

import java.awt.*;

/**
 * @author Dylan
 * @Date : 2021/3/30 - 22:58
 * @Description :
 * @Function :
 */
public class Tank {

    private int x = 200, y = 200;
    private Dir dir = Dir.Down;
    private static final int SPEED = 50;
    private boolean moving = false;
    private TankFrame tankFrame;


    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        move();
    }

    private void move(){
        if (!moving) {
            return;
        }
        switch (dir){
            case LEFT:
                if (x - SPEED >= 0){
                    x -= SPEED;
                }else {
                    x = 0;
                }
                break;
            case Right:
                if (x + SPEED <= 800){
                    x += SPEED;
                }else {
                    x = 800 - 50;
                }
                break;
            case UP:
                if (y - SPEED >= 20){
                    y -= SPEED;
                }else {
                    y = 20;
                }
                break;
            case Down:
                if (y + SPEED <= 600){
                    y += SPEED;
                }else {
                    y = 600 - 50;
                }
                break;
            default:
                break;
        }
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire(){
        tankFrame.bullets.add(new Bullet(this.x, this.y, this.dir, tankFrame));

    }

}
