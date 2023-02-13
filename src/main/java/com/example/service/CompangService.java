package com.example.service;


import com.example.pojo.Compang;

import java.util.List;

public interface CompangService {

    public Compang findById(Integer id);

    public List<Compang>  findAllCompang();

}
