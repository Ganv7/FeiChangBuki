package com.example.entity;

import lombok.Data;

@Data
public class OrderDetailVO {
    private Product product;
    private Myorder myorder;
    private Customer customer;
    public OrderDetailVO(){}
    public OrderDetailVO(Product product, Myorder myorder, Customer customer) {
        this.product = product;
        this.myorder = myorder;
        this.customer = customer;
    }
}
