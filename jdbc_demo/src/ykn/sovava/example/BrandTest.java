package ykn.sovava.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import ykn.sovava.pojo.Brand;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Description: 品牌数据的增删改查
 *
 * @author: ykn
 * @date: 2022年07月05日 18:09
 **/
public class BrandTest {
    /**
     * 查询所有
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
//        prop.load(new FileInputStream("jdbc_demo\\src\\druid.properties"));
        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //6.定义SQL语句
        String sql = "select * from tb_brand";
        //7.定义预编译Statement对象,,,之后进行可能的设置参数
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //8.获取查询结果
        ResultSet resultSet = pstmt.executeQuery();

        List<Brand> listBrand = new ArrayList<>();
        Brand brand = null;
        while (resultSet.next()) {
            brand = new Brand();
            brand.setId(resultSet.getInt("id"));
            brand.setBrandName(resultSet.getString("brand_name"));
            brand.setCompanyName(resultSet.getString("company_name"));
            brand.setOrdered(resultSet.getInt("ordered"));
            brand.setDescription(resultSet.getString("description"));
            brand.setStatus(resultSet.getInt("status"));
            listBrand.add(brand);
        }
        for (Brand brand1:listBrand){
            System.out.println(brand1.toString());
        }

        resultSet.close();
        pstmt.close();
        conn.close();
    }

    @Test
    public void testAdd() throws Exception {
        //接受页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //6.定义SQL语句
//        String sql = "select * from tb_brand";
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) Values(?,?,?,?,?)";
        //7.定义预编译Statement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //8.获取查询结果
//        ResultSet resultSet = pstmt.executeQuery();
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);


        //执行SQL
        int count = pstmt.executeUpdate();
        System.out.println(count);

//        resultSet.close();
        pstmt.close();
        conn.close();
    }
}
