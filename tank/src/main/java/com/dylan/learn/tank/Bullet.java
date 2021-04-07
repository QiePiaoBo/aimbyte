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
    public static int WIDTH = 20, HEIGHT = 20;
    private TankFrame tankFrame;
    private boolean living = true;
    private Group group;


    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if (!living){
            tankFrame.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case Down:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
            default:
                break;
        }
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
            living = false;
        }
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.group){
            return;
        }
        // todo: 不要每次都new
        Rectangle rectBullet = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(), tank.width, tank.height);
        if (rectBullet.intersects(rectTank)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
