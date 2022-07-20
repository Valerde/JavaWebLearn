package com.sovava.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Description: Servlet生命周期
 *
 * @author: ykn
 * @date: 2022年07月20日 18:17
 **/
@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法,
     *  1. 调用时机:默认情况下Servlet被第一次访问时调用
     *  2. 调用次数:一次
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供事务
     *      1. 调用时机:每一次Servlet被访问,调用
     *      2. 调用次数:多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world 2");
    }

    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     *  1. 调用时机:内存释放或者服务器关闭的时候,Servlet对象会被销毁
     *  2. 调用次数:多次
     */
    public void destroy() {
        System.out.println("destroyed...");
    }
}
