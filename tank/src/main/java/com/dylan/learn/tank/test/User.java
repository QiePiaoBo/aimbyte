package com.dylan.learn.tank.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dylan
 * @Date : Created in 13:20 2021/4/20
 * @Description :
 * @Function :
 */
public class User {

    private String name;

    private String age;

    private Long phone;

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public User(String name, String age, Long phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
