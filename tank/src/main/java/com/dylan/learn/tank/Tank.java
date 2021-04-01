package com.dylan.learn.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

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
    private boolean boss = false;
    private TankFrame tankFrame;
    BufferedImage image = null;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        try {
            image = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("images/tank.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        switch (dir){
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case Down:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move(){
        if (!moving) {
            return;
        }
        if (boss){
            return;
        }
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case Right:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case Down:
                y += SPEED;
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
        tankFrame.bullets.add(new Bullet(this.x + 15, this.y + 15, this.dir, tankFrame));

    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }
}
