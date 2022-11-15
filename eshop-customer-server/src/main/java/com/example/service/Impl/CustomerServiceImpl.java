package com.example.service.Impl;

import com.example.entity.Customer;
import com.example.mapper.CustomerMapper;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Customer getCusById(int cutId) {
        return customerMapper.selectByCustId(cutId);
    }
}
