package com.example.service;

import com.example.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
public interface IProductService {
    Product getProById(int id);
    List<Product> getProAll ();
}
