package com.dylan.learnmybatis.model.vo;

import java.io.Serializable;

/**
 * @author Dylan
 * @Date : Created in 14:08 2021/4/14
 * @Description :
 * @Function :
 */
public class AimRes implements Serializable {

    private String status;

    private String message;

    private Object data;

    public AimRes(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static AimRes success(){
        return new AimRes("0000", "OK", "");
    }

    public static AimRes fail(){
        return new AimRes("9999", "Failed", "");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
