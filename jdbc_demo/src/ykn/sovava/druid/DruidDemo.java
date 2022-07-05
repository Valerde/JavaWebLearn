package ykn.sovava.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Description: 数据连接池演示
 *
 * @author: ykn
 * @date: 2022年07月05日 17:24
 **/
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        //1.导入jar包

        //2.定义配置文件

        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc_demo/src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接Connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
