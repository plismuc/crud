package com.example.controller;

import com.example.pojo.Compang;
import com.example.service.CompangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compang")
public class UserController {

    @Autowired
    private CompangService compangService;

    /**
     * 通过id查询用户
     * @return
     */
    @RequestMapping("/{id}")
    public Compang findById(@PathVariable(name = "id") Integer id){
        return compangService.findById(id);
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public List<Compang> findAllCompang() {
        return compangService.findAllCompang();
    }
}
