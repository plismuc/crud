package com.example.controller;

import com.example.entity.Result;
import com.example.pojo.Company;
import com.example.service.CompanyServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServcie companyServcie;

    /**
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, 200, "查询成功", companyServcie.findAll());
    }

    /**
     * 按照ID查询
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable int id) {
        return new Result(true, 200, "按照ID查询成功", companyServcie.findById(id));
    }

    /**
     * 增加
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Company company) {
        companyServcie.save(company);
        return new Result(true, 200, "增加成功");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable int id) {
        companyServcie.delete(id);
        return new Result(true, 200, "删除成功");
    }

    /**
     * 查询出所有的结果带分页
     *
     * @return Mysql的分页语句    limit ?   ?
     * //默认第一页,每页3条
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public Result findAllPage(@PathVariable int page, @PathVariable int size) {
        return new Result(true, 200, "查询成功", companyServcie.findAllPage(page, size));
    }

    /**
     * 搜索功能 带条件带分页
     * 可能选择或者不选择
     * 公司的名字  模糊查询  阿里      like
     * isfamous   是不是  名企        =
     * state      公司状态可用不可用   =
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearchPage(@RequestBody Map search, @PathVariable int page, @PathVariable int size) {
        return new Result(true, 200, "查询成功", companyServcie.findSearchPage(search, page, size));
    }


}
