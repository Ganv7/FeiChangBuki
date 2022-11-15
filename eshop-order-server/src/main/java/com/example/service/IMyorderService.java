package com.example.service;

import com.example.entity.Myorder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Product;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2022-10-15
 */
public interface IMyorderService {
     boolean saveOrder(Myorder myorder);
     Myorder getOrderById(int orderId);
 }
