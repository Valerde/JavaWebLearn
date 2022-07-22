package com.sovava.web;

import com.sovava.mapper.UserMapper;
import com.sovava.pojo.User;
import com.sovava.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接受用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3 获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("hoqumapper");
        //查询用户对象是否存在
        User user1 = userMapper.selectByUsername(username);

        //判断用户是否存在
        if (user1!=null){

            System.out.println("进入已存在");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
            System.out.println("已存在");
        }else   {
            System.out.println("register");
            userMapper.add(user);
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
