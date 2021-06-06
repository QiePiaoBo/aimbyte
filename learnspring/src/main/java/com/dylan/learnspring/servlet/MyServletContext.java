package com.dylan.learnspring.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * ServletContext:
 *      作用：
 *          解决不同用户的数据共享问题
 *      特点：
 *          1. 由服务器创建
 *          2. 所有用户共享一个ServletContext对象
 *          3. 所有的Servlet都可以访问到同一个ServletContext中的属性
 *          4. 每一个web项目对应的是一个ServletContext
 *      用法：
 *
 */
@WebServlet(name = "myctxt", value = "/myctxt")
public class MyServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("gbk");
        System.out.println("myctxt get");
        // 获取ServletContext的方式
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = this.getServletConfig().getServletContext();
        ServletContext servletContext2 = request.getSession().getServletContext();
        // 检查三个获取ServletContext的方法是不是获取的同一个对象
        // System.out.println(servletContext == servletContext1);
        // System.out.println(servletContext == servletContext2);
        // System.out.println(servletContext1 == servletContext2);
        // 从ServletContext中获取属性
        Object attribute = servletContext.getAttribute("111");
        System.out.println("111 : " + (String) attribute);
        // 向ServletContext中设置属性
        servletContext.setAttribute("111", "张三");
        // 获取web.xml中设置的公共属性
        // Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        // while (initParameterNames.hasMoreElements()){
        //     String key = initParameterNames.nextElement();
        //     System.out.println("InitParameter: " + key + " : " + servletContext.getInitParameter(key));
        // }
        // 获取某个文件的真实路径
        String realPath = servletContext.getRealPath("web.xml");
        System.out.println("web.xml : " + realPath);
        // 获取web项目的上下文路径
        System.out.println(servletContext.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
