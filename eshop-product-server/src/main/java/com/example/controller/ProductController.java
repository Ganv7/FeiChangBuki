package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.entity.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private IProductService service;


    @SentinelResource(value = "getOrdById" ,blockHandler = "handlerHotKey",fallback = "ProductException")
    @GetMapping("product/getById/{id}")
    public Map<String,Object> getById(@PathVariable("id") Integer id){
        Product product =  service.getProById(id);
        Map<String,Object> ProMap = new HashMap<>();
        ProMap.put("ProId",product.getProId());
        ProMap.put("ProName",product.getProName());
        ProMap.put("ProDesc",product.getProDesc());
        ProMap.put("ProPrice",product.getProPrice());
        return ProMap;
    }


    @SentinelResource(value = "getOrdByAll" ,blockHandler = "handlerHotKey")
    @GetMapping("product/getAll")
    public List<Product> getAll(){
        return service.getProAll();
    }
    public String handlerHotKey(Integer orderId , BlockException exception){
        return "目前用户请求所有商品访问量过大，请稍后访问";
    }
    public String handlerHotKey(BlockException exception){
        return "目前用户请求所有商品访问量过大，请稍后访问";
    }
    public String ProductException(Integer orderId , BlockException exception){
        return "目前用户请求所有商品访问有异常，请稍后重试";
    }

}
