package com.example.service.Impl;

import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product getProById(int id) {
        return productMapper.selectByProId(id);
    }

    @Override
    public List<Product> getProAll() {
        return productMapper.selectAllPro();
    }
}
