package com.dylan.learnspring.model.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-04-14 13:56:29
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 704502681613065262L;

    private Integer id;

    private String userName;

    private Integer userAge;

    private Object userPhone;

    private String userDescription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Object getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Object userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

}
