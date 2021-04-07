package com.dylan.learn.tank;

import com.dylan.learn.tank.Dir;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @Date : 2021/3/30 - 23:00
 * @Description :
 * @Function :
 */
public class TankFrame extends Frame {

    static int GAME_WIDTH = 800;
    static int GAME_HEIGHT = 600;

    Tank myTank = new Tank(200, 400, Dir.Down, this);
    List<Tank> bosses = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<>();
    public TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    // 刷新事件
    @Override
    public void paint(Graphics g) {
        // 每刷新一次页面就执行一次该方法，调用repaint()方法时也会触发该方法
        // System.out.println("paint");
        Color c = g.getColor();
        g.setColor(Color.cyan);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌方坦克的数量：" + bosses.size(), 10, 80);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i ++){
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < bosses.size(); i ++){
            bosses.get(i).paint(g);
        }

        for (int i=0; i< bullets.size(); i ++){
            for (int j = 0; j < bosses.size(); j ++)
                bullets.get(i).collideWith(bosses.get(j));
        }
    }


    /**
     * 键盘监听事件
     */
    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;
        // 键盘按下
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        // 键盘松开
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 设置坦克方向
         */
        private void setMainTankDir(){

            if (!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
                if (bL){
                    myTank.setDir(Dir.LEFT);
                }
                if (bR){
                    myTank.setDir(Dir.Right);
                }
                if (bU){
                    myTank.setDir(Dir.UP);
                }
                if (bD){
                    myTank.setDir(Dir.Down);
                }
            }
        }

    }
}
