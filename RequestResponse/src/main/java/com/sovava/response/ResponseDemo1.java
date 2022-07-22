package com.sovava.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 重定向,<br>
 * 浏览器地址栏会发生变化<br>
 * 可以重定向到任意位置的资源(服务器内外均可)<br>
 * 两次请求,不能在多个资源之间使用request共享数据<br>
 */
@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1");

        //重定向
        //  1. 设置响应状态码
//        response.setStatus(302);
        //  2. 设置响应头 Location
//        response.setHeader("Location","Resp2");


        // 以上方法麻烦
//        response.sendRedirect("https://www.google.com");
        response.sendRedirect("/RequestResponse/req.html");
        /**
         * 资源路径问题:
         *  明确路径谁使用?
         *      浏览器使用:需要加虚拟路径(项目访问路径) 此处为RequestResponse
         *      服务器使用:不需要加虚拟路径
         */

        //获取虚拟路径的值
        String path = request.getContextPath();
//        response.sendRedirect(path+"/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
