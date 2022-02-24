package com.dylan.tomcat;

import com.dylan.tomcat.tomcat.traditional.GPRequest;
import com.dylan.tomcat.tomcat.traditional.GPResponse;

/**
 * @Classname GPServlet
 * @Description TODO
 * @Date 2022/2/21 10:45
 */
public abstract class GPServlet {

    public void service(GPRequest request, GPResponse response) throws Exception{
        if ("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request, response);
        }else {
            doPost(request, response);
        }
    }

    public abstract void doGet(GPRequest request, GPResponse response) throws Exception;
    public abstract void doPost(GPRequest request, GPResponse response) throws Exception;

}
