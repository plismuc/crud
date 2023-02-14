package com.example.dao;

import com.example.pojo.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyDao extends JpaRepository<Company,Integer> , JpaSpecificationExecutor<Company> {
    //里面基本的curd的基本方法就已经生成

    //查询可以的企业 state =1
    // findBy+字段  自动查询      _不能识别
       List<Company> findByState(int state);

     // ===> //登录功能   用户和密码都是正确  SQL  .... where name =? and  password=?
      //  User  findByNameAndPassword(String name,String password);
    //  List<Company> findAllOderBycreatedateDesc();

//    /**
//     * 带分页  并且按照ID 查询
//     * @param page
//     * @param size
//     * @return
//     */
    //第一种  字符串拼接   第二种占位置符号
//    @Query("select full_name, state  from t_compamy  limit ?1 , ?2  orderBy createdate")
//    List<Company> findAllPageOrdebyCreateDate(int page, int size);

    //查询出最近的可用的2个公司
     List<Company> findTop3ByStateOrderByCreatedateDesc(int state);

    /**
     * 如果熟悉中有下划线可能识别不了
     * @param state
     * @return
     */
     List<Company> findByIsfamous(int state);



     //nativeQuery = true  代表的是SQL语句

     @Transactional
     @Modifying     //SQL 注入
     @Query(value = "update t_company c set c.state = 1 where id=:id",nativeQuery = true)
     public void updateCompanyIsState_1(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update t_company c set c.state = 1 where id=?1",nativeQuery = true)
    public void update2CompanyIsState_1(@Param("id") Integer id);

    //面向对象的SQL语句   --->HQL
    @Transactional
    @Modifying     //SQL 注入
    @Query(value = "update Company c set c.state = 1 where id=:id")
    public void update3CompanyIsState_1(Integer id);

    @Transactional
    @Modifying     //SQL 注入
    @Query(value = "update Company c set c.state = 1 where id=?1")
    public void update4CompanyIsState_1(Integer id);
}
