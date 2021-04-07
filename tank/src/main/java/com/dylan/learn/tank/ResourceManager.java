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
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            for (int i = 1; i <= 16; i ++){
                explodes[i-1] = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/boom" + i + ".png")));
            }
            tankU = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/tank.png")));
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);
            tankD = ImageUtil.rotateImage(tankU, 180);

            bulletU = ImageIO.read((ResourceManager.class.getClassLoader().getResourceAsStream("images/bullet.png")));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);



        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
