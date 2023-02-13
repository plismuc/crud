package com.example.service.impl;

import com.example.mapper.CompangMapper;
import com.example.pojo.Compang;
import com.example.service.CompangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompangServiceImpl implements CompangService {

    @Autowired
    private CompangMapper compangMapper;

    @Override
    public Compang findById(Integer id) {
        return compangMapper.findById(id);
    }

    @Override
    public List<Compang>  findAllCompang() {
        List<Compang> compangList = compangMapper.findAllCompang();
        return compangList;
    }
}

