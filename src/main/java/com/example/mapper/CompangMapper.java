package com.example.mapper;


import com.example.pojo.Compang;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CompangMapper extends JpaRepository {

    public Compang findById(Integer id);

    public List<Compang> findAllCompang();
}
