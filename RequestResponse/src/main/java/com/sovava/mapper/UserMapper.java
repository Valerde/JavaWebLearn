package com.sovava.mapper;

import com.sovava.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * 用户名和密码查询用户对象
     *
     * @param username
     * @param password
     * @return User
     */
    @Select("select * from mydb2.tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from mydb2.tb_user where username = #{username}")
    User selectByUsername(String username);

    @Insert("insert into mydb2.tb_user values(null,#{username},#{password})")
    void add(User user);
}
