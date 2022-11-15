package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Myorder {
    private int orderId;
    private String orderNum;
    private int custId;
    private int proId;
    private Float orderPrice;
    private Date orderCreateTime;
    private int orderStatus;
}
