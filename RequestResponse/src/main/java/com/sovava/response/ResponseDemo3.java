package com.sovava.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应字符数据:设置字符数据的响应体
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp3");
        response.setContentType("text/html;charset=utf-8");
        //1. 获取数据输出流
        PrintWriter writer = response.getWriter();
        //未设置conten-type 会在浏览器上显示 aaa<h1> aaa</h1>
//        response.setHeader("content-type","text/html");
//      在getWriter之前设置response.setContentType("text/html;charset=utf-8");
        writer.write("你好");//不设置charset的时候中文会变成?
        writer.write("<h1> aaa</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
