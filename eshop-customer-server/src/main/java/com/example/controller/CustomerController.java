package com.example.controller;

import com.example.entity.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService service;
    @GetMapping("customer/getById/{id}")
    @ResponseBody
    public Map<String,Object> getById(@PathVariable("id") Integer id){
        Customer customer = service.getCusById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("custId",customer.getCustId());
        map.put("custName",customer.getCustName());
        map.put("custTelno",customer.getCustTelno());
        map.put("custEmail",customer.getCustEmail());
        return  map;
    }
}
