package com.dylan.learnbasic.learnjdbc;


/**
 * @author Dylan
 * @Date : 2021/10/31 - 11:38
 * @Description :
 * @Function :
 */

public class User {
    private Integer id;
    private String name;
    private Integer userGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
    }

    public void print(){
        System.out.println("id=" + getId() + ", name=" + getName() + ", group=" + getUserGroup());
    }
}
