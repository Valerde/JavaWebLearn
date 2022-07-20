package com.sovava.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月20日 17:48
 **/
@WebServlet("/demo1")//注解必须写"/"
public class ServletDemo1 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
