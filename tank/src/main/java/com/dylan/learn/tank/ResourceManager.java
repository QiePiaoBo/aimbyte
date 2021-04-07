package com.dylan.learn.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Dylan
 * @Date : Created in 13:17 2021/4/1
 * @Description :
 * @Function :
 */
public class ResourceManager {

    public static BufferedImage tankL, tankU, tankD, tankR;
    public static BufferedImage bulletL, bulletU, bulletD, bulletR;

    static {
        try {
            tankU = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/tank.png")));
            tankL = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/tank.png")));
            tankR = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/tank.png")));
            tankD = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/tank.png")));

            bulletL = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/bullet.png")));
            bulletR = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/bullet.png")));
            bulletU = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/bullet.png")));
            bulletD = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/bullet.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
