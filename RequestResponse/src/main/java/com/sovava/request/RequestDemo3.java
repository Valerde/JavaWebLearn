package com.sovava.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * Description: 获取请求头
 *
 * @author: ykn
 * @date: 2022年07月21日 17:43
 **/
@WebServlet("/demo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("get...");
        //1. 获取所有参数的Map 集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key :
                parameterMap.keySet()) {
            System.out.print(key + ":");
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("------------------");
        //2. 根据key值获取多数值数组
        String[] values = req.getParameterValues("hobby");
        for (String value:values){
            System.out.println(value);
        }

        System.out.println("---------------------");
        String username = req.getParameter("bobby");//如果此时有两个,那么返回null
        System.out.println(username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
        this.doGet(req, resp);
    }
}
