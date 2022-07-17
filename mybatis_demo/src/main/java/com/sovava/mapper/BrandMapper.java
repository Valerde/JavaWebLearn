package com.sovava.mapper;

import com.sovava.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月16日 16:41
 **/
public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 查看详情
     */
    Brand selectByIdBrand(int id);

    /**
     * 条件查询 1. 散装参数:如果方法中有多个参数,需要使用@Param("SQL参数占位符名称)
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    /**
     * 条件查询:2. 对象参数:对象的属性名要和占位符名称一致
     * @param brand
     * @return
     */
    List<Brand> selectByCondition(Brand brand);

    /**
     * map集合参数,需要保证SQL中的参数占位符的名称和map中键的名称一致
     * @param map
     * @return
     */
    List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加功能
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     * @param brand
     * @return
     */
    int update(Brand brand);

    /**
     * 删除一个
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);



}
