package com.dylan.learnspring.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 网站计数器
 */
@WebServlet(name = "NumberServlet", value = "/NumberServlet")
public class NumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("NumberServlet.doGet()");
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取servletContext
        ServletContext context = this.getServletContext();
        // 获取属性值
        Integer num = (Integer) context.getAttribute("num");
        if(num == null){
            context.setAttribute("num", 1);
            System.out.println("当前登录人数：" + 1);
            response.getWriter().write("当前登录人数：" + 1);
        }else {
            // 每次访问加一
            int added = num + 1;
            context.setAttribute("num", added);
            System.out.println("当前登录人数：" + added);
            response.getWriter().write("当前登录人数：" + added);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
