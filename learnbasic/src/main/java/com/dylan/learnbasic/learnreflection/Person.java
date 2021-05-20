package com.dylan.learnbasic.learnreflection;

import java.io.Serializable;

/**
 * @author Dylan
 * @Date : Created in 13:30 2021/5/20
 * @Description :
 * @Function :
 */
public class Person implements Serializable {
    private int age;
    public String name;

    private void eat(){
        System.out.println("Person---eat");
    }
    public void sleep(){
        System.out.println("Peron---sleep");
    }
}