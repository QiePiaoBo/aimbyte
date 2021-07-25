package com.dylan.learnspring.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Dylan
 * @Date : Created in 9:53 2020/12/31
 * @Description : 拦截器 检查路由
 * @Function :
 */
public class UrlCheckInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(UrlCheckInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        logger.info("PreHandle.");
        String url = request.getRequestURL().toString().toLowerCase();
        // 如果路由中包含test，允许访问
        // 拦截器开放error页面的请求权限
        if (url.contains("test") || url.contains("error")){
            flag = true;
        }
        // 如果路由中端口后的部分长度为1，即访问路径为服务根路径，就允许访问
        String subUrl = url.substring(url.indexOf("/"));
        if (subUrl.length() < 2){
            flag = true;
        }
        return flag;
    }
}
