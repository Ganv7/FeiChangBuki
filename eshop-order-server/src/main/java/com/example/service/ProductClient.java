package com.example.service;


import com.example.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 商品服务客户端
 */
@FeignClient(name="product-server")
public interface ProductClient {
    @GetMapping("product/getById/{id}")
    Map<String,Object> getProById(@PathVariable("id") Integer id);
//    @PostMapping("product/getById/{id}")
//    Product saveOrder(@PathVariable("id") Integer id);

}
