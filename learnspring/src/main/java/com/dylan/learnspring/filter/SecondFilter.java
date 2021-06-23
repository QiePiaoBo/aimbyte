package com.dylan.learnspring.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Dylan
 * @Date : Created in 10:37 2020/12/31
 * @Description : 第二个过滤器
 * @Function :
 */
@Order(2)
@WebFilter(urlPatterns = {"/**"}, filterName = "filter2")
public class SecondFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SecondFilter.class);

    @Value("${spring.redis:null}")
    private String redisConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Second filter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest){
            logger.info("Second filter doFilter()");
            HttpServletRequest HRrequest = (HttpServletRequest) servletRequest;
            Cookie[] cookies = HRrequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("loginUser")) {
                        logger.info("find loginUser: " + cookie.getValue());
                        break;
                    }
                }
            }else {
                logger.info("No cookie found in request found.(SecondFilter)");
            }
            // 请求中含有redis时,检查redisserver
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String url = httpServletRequest.getRequestURI();
            if (url.toLowerCase().contains("testredis")){
                if ("null".equals(redisConfig)){
                    ServletOutputStream out = servletResponse.getOutputStream();
                    out.write("Redis server config not found.".getBytes());
                    out.flush();
                    out.close();
                }
            }
        }


        // 当前过滤器处理完了交给下一个过滤器处理
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("Second filter destroy()");
    }
}
