package com.dylan.tomcat.tomcat.traditional;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Classname GPResponse
 * @Description TODO
 * @Date 2022/2/21 10:56
 */
public class GPResponse {

    private OutputStream out;

    public GPResponse(OutputStream out){
        this.out = out;
    }

    public void write(String s) throws Exception{
        // 输出也要遵循HTTP
        // 状态码为200
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html;\n")
                .append("\r\n")
                .append(s);
        out.write(sb.toString().getBytes(StandardCharsets.UTF_8));
    }

}
