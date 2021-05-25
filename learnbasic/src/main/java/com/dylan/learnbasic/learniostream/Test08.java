package com.dylan.learnbasic.learniostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Dylan
 * @Date : Created in 13:03 2021/5/24
 * @Description :
 * @Function :
 */
public class Test08 {
    public static void main(String[] args) throws Exception {
        // FileInputStream + FileOutputStream 图片复制
        File sourceImg = new File("fileTestDir/test04/source.jpg");
        File aimImg = new File("fileTestDir/test04/aim.jpg");

        FileInputStream fin  = new FileInputStream(sourceImg);
        FileOutputStream fot = new FileOutputStream(aimImg);

        int n;
        byte[] buffer = new byte[1024];
        while ((n = fin.read(buffer)) != -1){
            System.out.println(n);
            fot.write(buffer);
        }
        fot.close();
        fin.close();
    }
}
