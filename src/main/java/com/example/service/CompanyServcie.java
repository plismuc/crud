package com.example.service;

import com.example.dao.CompanyDao;
import com.example.pojo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CompanyServcie {

    @Autowired
    private CompanyDao companyDao;

    /**
     * 查询所有
     * @return
     */
    public List<Company> findAll(){
        return companyDao.findAll();
    }

    /**
     * 按照ID查询
     * @param id
     * @return
     */
    public Company findById(int id) {
          return  companyDao.findById(id).get();
    }

    public void save(Company company) {
         //随机数字--->雪花算法 保证ID 特别是分布式的场景下
        company.setCreatedate(new Date());
        companyDao.save(company);
    }

    public void delete(int id) {
        companyDao.deleteById(id);
    }

    public Object findAllPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return  companyDao.findAll(pageRequest);
    }

    /**
     *    公司的名字  模糊查询  阿里      like   %aaa%   只要包含aaa的结果都出来的
     *      *    isfamous   是不是  名企        =
     *      *    state      公司状态可用不可用   =
     *
     *      Map  {
     *              key: name      value
     *              key: isfamosu  value: 1
     *              key: state     value:1
     *       }
     *
     * @param search
     * @param page  页数
     * @param size  每页几条
     * @return
     */
    public Page<Company> findSearchPage(Map search, int page, int size) {
        Specification specification = cratespPecification(search);//拼接条件   if(key不等于空){ 拼接上去 }
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return companyDao.findAll(specification,pageRequest);
    }

    public Page<Company> findSearchBypage(Map whereMAP, int page, int size){
        Specification specification = cratespPecification(whereMAP);
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return companyDao.findAll(specification,pageRequest);
    }

    /**
     * 拼接条件
     *
     *      Map  {
     *              key: shorname     value
     *              key: isfamosu  value: 1
     *              key: state     value:1
     *       }
     *       拼接条件   if(key不等于空){ 拼接上去 }
     */
    private Specification cratespPecification(Map search) {
         return new Specification() {
             //1.把我所有的条件
             List<Predicate> predicateList = new ArrayList<Predicate>();
             @Override
             public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                 //1.判断用户没有传递公司的名字过来
                 if(search.get("short_name")!=null&&!"".equals(search.get("short_name"))){
                     predicateList.add(cb.like(root.get("short_name").as(String.class),
                             "%"+search.get("short_name")+"%"));
                 }
                 if(search.get("isfamous")!=null&&!"".equals(search.get("isfamous"))){
                     predicateList.add(cb.equal(root.get("is_famous").as(String.class),
                             "%"+search.get("isfamous")+"%"));
                 }
                 if(search.get("state")!=null&&!"".equals(search.get("state"))){
                     predicateList.add(cb.equal(root.get("state").as(String.class),
                             "%"+search.get("state")+"%"));
                 }
                 return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
             }
         };
    }

//    public List<Company> findAllPageOrdebyCreateDate(int page, int size) {
//         //依次向里面添加条件
//        // 很多中方法去实现   ===>总感觉差点
//        // 自己写方法
          //1.定义Sort  ---> 2.拼接dao方法   3.数据处理   4.SQL语句(多表)
//
//        //稍微复杂的数据操作   ====>SQL解决
//        //自己去写SQL语句
//        return  companyDao.findAllPageOrdebyCreateDate(page,size);
//
//    }
}
