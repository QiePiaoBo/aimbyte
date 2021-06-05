package com.dylan.learnmybatis.model.vo;

/**
 * @author Dylan
 * @Date : Created in 14:06 2021/4/14
 * @Description :
 * @Function :
 */
public class UserVo {


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
