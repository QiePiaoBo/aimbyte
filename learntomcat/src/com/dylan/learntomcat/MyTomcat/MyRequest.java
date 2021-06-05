package com.dylan.learntomcat.MyTomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Dylan
 * @Date : 2021/6/5 - 20:00
 * @Description :
 * @Function :
 */
public class MyRequest {
    // 请求方法 get、post
    private String requestMethod;
    // 请求地址
    private String requestUrl;

    public MyRequest(InputStream in) throws IOException {
        // 从流中取数据
        byte[] buffer = new byte[1024];
        // 读取数据的长度
        int len = 0;
        // 定义请求的变量
        String str = null;
        if ((len = in.read(buffer)) != -1){
            str = new String(buffer, 0, len);
        }
        // 将str解析成属性 这里取第一行(GET / HTTP/1.1)
        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        this.requestUrl = params[1];

    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
