package com.example.crud;

import com.example.mapper.CompangMapper;
import com.example.pojo.Compang;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)//使用SpringRunner运行器
@SpringBootTest     //启动springboot测试
public class CompangApplicationTest {

    @Autowired
    private CompangMapper compangMapper;

    @Test
    public void getUser() {
//        List<Compang> all = compangMapper.findAll();
//        for (Compang compang : all) {
//            System.out.println(compang);
//        }

        List<Compang> all = compangMapper.findAllCompang();
        System.out.println(all);
    }
}


