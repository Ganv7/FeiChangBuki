package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Customer;

public interface CustomerMapper extends BaseMapper<Customer> {
    public Customer selectByCustId(int custId);
}
