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
public class JDBCDemo5_ResultSet {
    /**
     * Description: 执行对应的DQL语句和ResultSet
     *
     * @author: ykn
     * @date: 2022/7/5 14:11
     * @return: void
     */
    @Test
    public void testResultSet() throws Exception {
//1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url, username, password);

        //3.定义sql,有没有分号都一样
//        String sql = "UPDATE product3 SET product_count = 100 WHERE category_id ='c001'";
        String sql = "select * from product";

        //获取执行SQL的对象statement
//        Statement stmt = coon.createStatement();
        Statement stmt = coon.createStatement();
        //5.执行sql
//        int count = stmt.executeUpdate(sql);//受影响的行数
        ResultSet resultSet = stmt.executeQuery(sql);
        //处理结果
//        System.out.println(count);
        while (resultSet.next()) {
//            String pid = resultSet.getString(1);
//            String name = resultSet.getString(2);
//            double price = resultSet.getDouble(3);
            int id = resultSet.getInt("pid");
            String name = resultSet.getString("pname");
            double price = resultSet.getDouble("price");
            System.out.println(id + "--" + name + "--" + price);
        }
        //7.释放资源
        stmt.close();
        coon.close();
    }

    /**
     * Description: 查询Product数据,封装到Product对象中,并且存储到ArrayList集合中
     *
     * @author: ykn
     * @date: 2022/7/5 15:02
     * @return: void
     */
    @Test
    public void testResultSet2() throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url, username, password);

        //3.定义sql,有没有分号都一样
        String sql = "select * from product";

        //获取执行SQL的对象statement
        Statement stmt = coon.createStatement();
        //5.执行sql
        ResultSet resultSet = stmt.executeQuery(sql);
        //处理结果
        List<Product> list = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
//            String pid = resultSet.getString(1);
//            String name = resultSet.getString(2);
//            double price = resultSet.getDouble(3);
            int id = resultSet.getInt("pid");
            String name = resultSet.getString("pname");
            double price = resultSet.getDouble("price");
            String categoryId = resultSet.getString("category_id");
            //System.out.println(id + "--" + name + "--" + price);
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setCategoryId(categoryId);
            list.add(product);
        }
        //7.释放资源
        stmt.close();
        coon.close();

        for (Product p : list) {
            System.out.println(p.toString());
        }
    }
}
