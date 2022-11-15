package com.example.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.entity.Myorder;
import com.example.entity.Product;
import com.example.mapper.MyorderMapper;
import com.example.service.IMyorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Component
public class MyorderServiceImpl  implements IMyorderService {
    @Autowired
    private MyorderMapper myorderMapper;

    //    blockHander:负责处理 违背sentinel时运行兜底方法
//    fallback: 负责处理业务出现异常时执行对应的兜底方法


    @Override

    public boolean saveOrder(Myorder myorder) {
        return myorderMapper.saveOrder(myorder)>0;
    }


    @Override
    public Myorder getOrderById(int orderId) {
        return myorderMapper.getByOrdId(orderId);
    }


}
