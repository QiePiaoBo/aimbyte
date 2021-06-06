package com.dylan.learnspring.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Dylan
 * @Date : 2021/5/9 - 12:39
 * @Description :
 * @Function :
 */
@WebServlet(name = "myServlet", urlPatterns = "mysvlt")
public class MyServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(MyServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 无论做什么 第一步都要设置编码格式
         */
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("gbk");
        resp.setContentType("text/html;charset=utf-8");
        // 获取cookie
        Cookie[] cookies = req.getCookies();
        if (null != cookies && (cookies.length > 0)){
            for (Cookie c : cookies){
                String key = c.getName();
                String value = c.getValue();
                System.out.println("Cookie: --->" + key + " : " + value);
            }
        }

        System.out.println("myServlet.get()");
        /**
         * 请求行中的信息
         */
        // 获取请求中的请求方式
        System.out.println(req.getMethod());
        // 获取请求中的完整地址
        System.out.println(req.getRequestURL());
        // 获取请求中的资源路径 虚拟项目名称+别名
        System.out.println(req.getRequestURI());
        // 获取请求中的协议
        System.out.println(req.getScheme());
        /**
         * 获取请求头中的信息
         * 根据key获取value
         */
        // 获取请求头中的信息
        System.out.println(req.getHeader("User-Agent"));
        // 获取请求头中所有的key
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            System.out.println("key:" + key);
            System.out.println("value: " + req.getHeader(key));
        }
        /**
         * 获取用户请求数据
         */
        // 无论请求方式是post还是get，获取请求数据的方式不变
        String name = req.getParameter("name");
        System.out.println("Parameter: name-" + name);
        // 获取所有的用户请求数据
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.print("用户请求数据：");
            String key = parameterNames.nextElement();
            System.out.println(key + "-" + req.getParameter(key));
        }
        // 常用其他方法
        // 获取远程客户端的地址信息
        String remoteAddr = req.getRemoteAddr();
        String remoteHost = req.getRemoteHost();
        int remotePort = req.getRemotePort();
        System.out.println("remoteInfo: " + remoteAddr + " : " + remoteHost + " : " + remotePort);

        String localAddr = req.getLocalAddr();
        String localName = req.getLocalName();
        int localPort = req.getLocalPort();
        System.out.println("localInfo: " + localAddr + " : " + localPort + " : " + localName);

        /**
         * 设置响应头，按照kv键值对的方式来设置
         */
        // setHeader在存在相同的key时会覆盖
        resp.setHeader("hehe", "haha");
        // addHeader在存在相同key时不会覆盖
        resp.addHeader("beijing", "shanghai");
        // 设置响应信息的格式 服务端返回的数据格式要按照一定的格式要求进行渲染，只有时html格式才会识别html中的标签
        // resp.setHeader("Content-Type", "text/html");
        resp.setHeader("Content-Type", "text/plain");
        //resp.setContentType("text/html");
        // 设置响应状态码
        // resp.sendError(404);
        resp.getWriter().write("<b>java is easy</b>");
        // 设置cookie
        // cookie是保存在浏览器中的
        // cookie有两种：临时cookie(默认存储在内存中，当浏览器关闭的时候就会失效)和持久化cookie(可以通过设置过期时间的方式，到了过期时间才会失效)
        // 每个cookie对象中保存一个key-value键值对的数据，想要存储多个k-v数据，需要创建多个Cookie对象
        Cookie cookie1 = new Cookie("name", "dylan");
        Cookie cookie2 = new Cookie("age", "24");
        // 给cookie添加有效期，单位是s
        cookie1.setMaxAge(3*24*3600);
        // 给cookie设置固定路径值,只有设置的路径才会加上这个cookie的对象
        cookie1.setPath("/mysvlt");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

        /**
         * Session
         */
        // 获取Session对象 自动封装到cookie中
        HttpSession session = req.getSession();
        if (null != session.getAttribute("111")){
            System.out.println("session value :" + session.getAttribute("111"));
        }
        System.out.println("session id : " + session.getId());
        // 修改session的有效时间 单位是s
        //session.setMaxInactiveInterval(5);
        // 设置session强制失效 每次发送请求都会获得一个新的session
        // session.invalidate();
        // 向session中设置参数
        session.setAttribute("111", "张三");
        resp.getWriter().write("学习session");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
