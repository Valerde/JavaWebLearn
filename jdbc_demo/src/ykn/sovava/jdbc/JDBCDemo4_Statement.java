package ykn.sovava.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月04日 20:05
 **/
public class JDBCDemo4_Statement {
    /**
     * Description: 执行对应的DML语句
     *
     * @author: ykn
     * @date: 2022/7/5 14:11
     * @return: void
     */
    @Test
    public void testDML() throws Exception {
//1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url, username, password);

        //3.定义sql,有没有分号都一样
        String sql = "UPDATE product3 SET product_count = 100 WHERE category_id ='c001'";

        //获取执行SQL的对象statement
        Statement stmt = coon.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql);//受影响的行数

        //处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        coon.close();
    }
/**
 * Description: 执行DDL
 * @author: ykn
 * @date: 2022/7/5 14:20
 * @return: void
 */
    @Test
    public void testDDL() throws Exception{
//1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url,username,password);

        //3.定义sql,有没有分号都一样
        String sql = "drop database db2";//删除成功返回值为0

        //获取执行SQL的对象statement
        Statement stmt = coon.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql);//受影响的行数

        //处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        coon.close();
    }
}
