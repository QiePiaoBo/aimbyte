package com.dylan.learn.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/**
 * @author Dylan
 * @Date : 2021/3/30 - 22:58
 * @Description :
 * @Function :
 */
public class Tank {

    private int x = 200, y = 200;
    private Dir dir = Dir.Down;
    private static final int SPEED = 1;
    private boolean moving = true;
    private boolean boss = false;
    // 持有画布引用
    private TankFrame tankFrame;
    // 出示图片
    BufferedImage image = null;
    // 宽度高度
    public int width = 50;
    public int height = 50;
    // 是否存活
    private boolean living = true;
    // 随机
    private Random random = new Random();
    // 区分敌我
    Group group = Group.BAD;

    public Tank(int x, int y, Dir dir,Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
        try {
            image = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("images/tank.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        if (!living){
            tankFrame.bosses.remove(this);
        }
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
        if (this.group == Group.BAD && random.nextInt(10) > 8)
            this.fire();
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire(){
        int bX = this.x + this.width / 2 - Bullet.WIDTH / 2;
        int bY = this.y + this.height / 2 - Bullet.HEIGHT / 2;
        tankFrame.bullets.add(new Bullet(bX, bY, this.dir, this.group, tankFrame));

    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void die(){
        this.living = false;
    }
}
