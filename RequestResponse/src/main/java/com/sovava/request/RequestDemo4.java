package com.sovava.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/demo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("UTF-8");
        //1. 获取中文名字username
        String username = request.getParameter("username");
        System.out.println(username);
        //æ¨å¯æ¥   乱码
        //2. 解决乱码
        //  POST:底层getReader
        //  POST解决办法:request.setCharacterEncoding("UTF-8");

        //  GET:  底层getQueryString
        //  乱码原因:浏览器UTF-8通过URL编码编成%E5类型的,tomcatURL解码后把字节码默认按ISO-8859-1编码
        //  解决:转换一下,转换方法对于POST也同样适用
        System.out.println(parse(username));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    public String parse(String s) throws UnsupportedEncodingException {
        byte[] bytes = s.getBytes("ISO-8859-1");
        return new String(bytes, "utf-8");

    }

}
