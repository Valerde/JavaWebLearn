package ykn.sovava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Description: JDBC API详解:DriverManager
 *
 * @author: ykn
 * @date: 2022年07月04日 20:05
 **/
public class JDBCDemo2_Connection {
    public static void main(String[] args) throws Exception {
        //1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url, username, password);

        //3.定义sql,有没有分号都一样
        String sql = "UPDATE product3 SET product_count = 20 WHERE category_id ='c001'";

        //获取执行SQL的对象statement
        Statement stmt = coon.createStatement();

        try {//开启事务------------------------------------------------
            coon.setAutoCommit(false);
            //5.执行sql
            int count = stmt.executeUpdate(sql);//受影响的行数
            int i = 3/0;
            //处理结果
            System.out.println(count);

            //提交事务
            coon.commit();
        } catch (Exception e) {
            //回滚事务
            coon.rollback();
//            e.printStackTrace();
        }

        //7.释放资源
        stmt.close();
        coon.close();
    }
}
