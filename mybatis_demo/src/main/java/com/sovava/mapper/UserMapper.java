package com.sovava.mapper;

import com.sovava.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
1. 定义与SQL映射文件同名的Mapper接口，并且将Mapper接口和SQL映射文件放置在同一目录下。
2. 设置SQL映射文件的namespace属性为Mapper接口全限定名
3. 在 Mapper 接口中定义方法，方法名就是SQL映射文件中sql语句的id，
   并保持参数类型和返回值类型一致
 */
public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

    /**
     * MyBatis 参数封装
     *      *单个参数
     *          1. POJO类型:直接使用,属性名和参数占位符名称一直
     *          2. Map集合:直接使用,键名和参数占位符名称一致
     *          3. Collection 封装为map集合
     *              map.put("args0",collection集合);
     *              map.put("collection",collection集合);
     *          4. List
     *              map.put("args0",list集合);
     *              map.put("collection",list集合);
     *              map.put("list",list集合);
     *          5. Array
     *              map.put("args0",数组);
     *              map.put("array",数组);
     *          6. 其他类型 直接使用
     *      * 多个参数:封装为map集合,可以使用Param注解,替换Map集合中磨人的arg键名
     *          map.put("args0",参数1);
     *          map.put("param1",参数1);
     *          map.put("args1",参数2);
     *          map.put("param2",参数2);
     *          ----------------------------@Param("username")
     *          map.put("username",参数1);
     *          map.put("param1",参数1);
     *          map.put("args1",参数2);
     *          map.put("param2",参数2);
     * @param username
     * @param password
     * @return
     */
//    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 基础的增删改查,@Select,@Insert,@Update,@Delete使用注解比配置文件更为方便,
     * 但是仅仅适用于简单功能.
     *
     * @return
     */
    @Select("select * from tb_brand")
    List<User> selectAlls();
}
