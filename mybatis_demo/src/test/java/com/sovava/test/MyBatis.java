package com.sovava.test;

import com.sovava.mapper.BrandMapper;
import com.sovava.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月16日 16:29
 **/
public class MyBatis {
    @Test
    public void testSelectAll() throws IOException {
        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
        List<Brand> brandList = brandMapper.selectAll();

        System.out.println(brandList);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectById() throws IOException {
        int id = 2;


        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
//        List<Brand> brandList = brandMapper.selectAll();
        Brand brand = brandMapper.selectByIdBrand(id);

        System.out.println(brand);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectByCondition() throws IOException {
        //模拟接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //使用List<Brand> selectByCondition(Brand brand);
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);

        //使用List<Brand> selectByCondition(Map map);
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("brandName", brandName);
//        map.put("companyName",companyName);

        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);


        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //模拟接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //使用List<Brand> selectByCondition(Brand brand);
        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setStatus(status);


        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
//        List<Brand> brands = brandMapper.selectByCondition(map);


        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testAdd() throws IOException {
        //模拟接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String decription = "手机中的战斗机";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setDescription(decription);
        brand.setOrdered(ordered);

        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
        brandMapper.add(brand);
        int id = brand.getId();
        System.out.println(id);

        //attention:需要提交事务,如果使用opensession();那么默认自动提交是关闭的,如果使用opensession(true)就代表开启了自动提交事务
//        sqlSession.commit();


        System.out.println(brandMapper.selectAll());

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testUpdate() throws IOException {
        //模拟接收参数
        int id = 6;
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String decription = "只修改一个";
        int ordered = 200;


        Brand brand = new Brand();
        brand.setId(id);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setStatus(status);
        brand.setDescription(decription);
//        brand.setOrdered(ordered);

        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);

        //attention:需要提交事务,如果使用opensession();那么默认自动提交是关闭的,如果使用opensession(true)就代表开启了自动提交事务
//        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testDelectById() throws IOException {
        //模拟接收参数
        int id = 8;


        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
        brandMapper.deleteById(id);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testDelectByIds() throws IOException {
        //模拟接收参数
        int[] ids = {5, 6, 7};


        //1. 获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4. 执行方法
        brandMapper.deleteByIds(ids);

        //5.释放资源
        sqlSession.close();
    }
}
