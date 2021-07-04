package com.dylan.learnbasic.learnjvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @author Dylan
 * @Date : 2021/7/4 - 22:50
 * @Description :
 * @Function :
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("G:\\Java\\Msb\\aimbyte\\clsLoaderTestDir", name.replaceAll("\\.", "/").concat(".class"));
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(f);
            baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) != 0){
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            fis.close();
            baos.close();
            return defineClass(name, bytes, 0, bytes.length);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != baos){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.findClass(name);
    }

    public static void main(String[] args) {
        ClassLoader my = new MyClassLoader();
        try {
            System.out.println(my.loadClass("com.dylan.Hello"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
