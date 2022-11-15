package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name="customer-server")
public interface CustomerClient {
    @GetMapping("customer/getById/{id}")
    Map<String,Object> getCusById(@PathVariable("id") Integer id);
//    @PostMapping("product/getById/{id}")
//    Product saveOrder(@PathVariable("id") Integer id);

}
