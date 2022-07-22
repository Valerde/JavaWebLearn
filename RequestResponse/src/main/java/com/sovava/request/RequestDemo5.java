package com.sovava.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *  请求转发,把请求从5 转发到6
 *  转发特点:
 *      1. 浏览器地址栏路径不发生变化
 *      2. 只能转发到当前服务器的内部资源
 *      3. 一次请求,可以在转发的资源间使用request共享数据
 */
@WebServlet("/demo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo5");

        //转发的时候设置共享数据
        request.setAttribute("msg","杨凯楠");//

        //必须在自己服务器里面转发
        request.getRequestDispatcher("/demo6").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
