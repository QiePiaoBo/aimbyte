package com.dylan;

/**
 * @Classname NettyLearnEnum
 * @Description 端口号 端口名枚举
 * @Date 2022/2/21 10:12
 */
public enum NettyLearnEnum {

    DY_CHAT("DY_CHAT", 8007),
    ECHO("ECHO", 8008),
    HTTP2("HTTP2", 8009),
    HTTP("HTTP", 8010),
    TOMCAT("TOMCAT", 8011)
    ;

    NettyLearnEnum(String name, int port) {
        this.name = name;
        this.port = port;
    }

    private String name;
    private int port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
