package com.sovava.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Description: 获取请求头
 *
 * @author: ykn
 * @date: 2022年07月21日 17:43
 **/
@WebServlet("/demo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String getMethod();获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        //String getContextPath();获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //StringBuffer getRequestURL();获取URL(统一资源定位符):http://localhost:8080/RequestResponse/demo1
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());

        //String getRequestURI();获取URI(统一资源标识符):/RequestResponse/demo1
        String uri = req.getRequestURI();
        System.out.println(uri);

        //String getQueryString();获取请求参数(GET方式):username=zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //--------------------------
        //获取请求头

        //user-agent:浏览器的版本信息
        String agent = req.getHeader("user-agent");
        System.out.println(agent);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post请求体

        System.out.println("---");
        //1.获取字符输入流
        BufferedReader br = req.getReader();
        //2. 获取数据
        String line = br.readLine();
        System.out.println(line);
    }
}
