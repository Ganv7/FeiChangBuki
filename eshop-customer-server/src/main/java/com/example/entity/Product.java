package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private int proId;
    private String proName;
    private Float proPrice;
    private String proDesc;
}
