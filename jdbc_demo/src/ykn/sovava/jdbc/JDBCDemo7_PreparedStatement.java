package ykn.sovava.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月04日 20:05
 **/
public class JDBCDemo7_PreparedStatement {
    /**
     * Description: PreparedStatement
     *
     * @author: ykn
     * @date: 2022/7/5 14:11
     * @return: void
     */
    @Test
    public void testLogin() throws Exception {

        //2.获取驱动
        String url = "jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8&useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "ykn12345";
        Connection coon = DriverManager.getConnection(url, username, password);

        //接受用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = ? and password = ?";

        PreparedStatement pstmt = coon.prepareStatement(sql);

        pstmt.setString(1, name);
        //通过设置参数防止注入,在传递的时候会转义'转为/'
        pstmt.setString(2, pwd);//

        ResultSet rs = pstmt.executeQuery();


        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
        }

        //7.释放资源
        pstmt.close();
        coon.close();
    }


}
