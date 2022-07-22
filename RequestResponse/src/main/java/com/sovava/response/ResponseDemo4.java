package com.sovava.response;



import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字节数据:设置字节数据的响应体
 */
@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp4");

        //1. 读取文件
        FileInputStream fis = new FileInputStream("D:\\我的2\\京剧\\视频\\马前泼水.mp4");

        //2. 获取字节输出流
        ServletOutputStream sos = response.getOutputStream();


        //3. 完成流的copy
//
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = fis.read(buffer)) != -1) {
//            sos.write(buffer, 0, len);
//        }

        IOUtils.copy(fis,sos);
//        IOUtils.
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
