package com.sovava.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:<br>
 * urlPaterns:<br>
 * 1. 精确匹配:全打<br>
 * 2. 目录匹配:/user/*   表示前面是user,后面写啥都能访问到,比如写/user/a或者/user/b都可以<br>
 * 3. 扩展名匹配:"*.do" 凡是这个扩展名的都是,需要注意不可以在前面加/<br>
 * 4. 任意匹配:  /  或者  /*  /*的优先级比/高<br>
 *      Servlet中配置了/ 和/*后,就把默认的DefaultServlet覆盖掉了<br>
 *      DefaultServlet为了静态资源服务的,就访问不了a.html了<br>
 *
 * @author: ykn
 * @date: 2022年07月20日 23:14
 **/
@WebServlet(urlPatterns = {"/demo7/select", "/demo8", "/user/*", "*.do", "/", "/*"})
public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get......urlPatterns");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post......");
    }
}
