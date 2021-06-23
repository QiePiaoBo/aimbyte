package com.dylan.learnspring.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Dylan
 * @Date : Created in 10:32 2020/12/31
 * @Description : 第一个过滤器
 * @Function :
 */
@Order(1)
@WebFilter(urlPatterns = {"/**"}, filterName = "filter1")
public class FirstFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(FirstFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("First filter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("First filter doFilter()");
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
            logger.info("No cookie found in request found.(FirstFilter)");
        }

        // 当前过滤器处理完了交给下一个过滤器处理
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("First filter destroy()");
    }
}
