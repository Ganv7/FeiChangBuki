package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Product;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    Product selectByProId(int proId);
    List<Product> selectAllPro();
}
