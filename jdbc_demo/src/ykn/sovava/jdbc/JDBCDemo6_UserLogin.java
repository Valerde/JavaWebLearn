package ykn.sovava.jdbc;

import org.junit.Test;
import ykn.sovava.pojo.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月04日 20:05
 **/
public class JDBCDemo6_UserLogin {
    /**
     * Description: 简单登录
     *
     * @author: ykn
     * @date: 2022/7/5 14:11
     * @return: void
     */
    @Test
    public void testLogin() throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url, username, password);

        //接受用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";

        Statement stmt = coon.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }


        //7.释放资源
        stmt.close();
        coon.close();
    }

    /**
     * Description: 演示SQL注入
     * @author: ykn
     * @date: 2022/7/5 15:40
     * @return: void
     */
    @Test
    public void testLogin2() throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url, username, password);

        //接受用户名和密码
        String name = "hnfcmfx";
//        String pwd = "' or '1' ='1";
        String pwd = "" ;

        String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";

        Statement stmt = coon.createStatement();

        ResultSet rs = stmt.executeQuery(sql);


        if (rs.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }


        //7.释放资源
        stmt.close();
        coon.close();
    }

}
