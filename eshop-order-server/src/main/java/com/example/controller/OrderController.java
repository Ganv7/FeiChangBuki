package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Customer;
import com.example.entity.Myorder;
import com.example.entity.OrderDetailVO;
import com.example.entity.Product;
import com.example.service.CustomerClient;
import com.example.service.IMyorderService;
import com.example.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private IMyorderService service;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private CustomerClient customerClient;
    @SentinelResource(value = "saveOrder" ,blockHandler = "saveOrderHot")
    @PostMapping("order/saveOrder")
    public String saveOrder(){
        Myorder myorder = new Myorder();
        myorder.setOrderNum("1000102321");
        myorder.setCustId(1);
        myorder.setProId(1);
        myorder.setOrderPrice(134.5f);
        myorder.setOrderCreateTime(new Date());
        myorder.setOrderStatus(1);
        boolean result =  service.saveOrder(myorder);
        if (result)
            return "添加成功";
        else
            return "添加失败，怎么会怎么会，你竟原谅了我";
    }
    @SentinelResource(value = "getOrdById" ,blockHandler = "handlerHotKey")
    @GetMapping("order/getOrdById/{orderId}")
    public Map<String,Object> getOrdById(@PathVariable("orderId") Integer orderId){
      Myorder order =   service.getOrderById(orderId);
      Map<String,Object> productMap = productClient.getProById(order.getProId());
      Map<String,Object> customerMap = customerClient.getCusById(order.getCustId());
      System.out.println(order);
      System.out.println(productMap);
      System.out.println(customerMap);
      Map<String,Object> result = new HashMap<>();
      result.put("order",order);
      result.put("product",productMap);
      result.put("customer",customerMap);
    //  OrderDetailVO orderDetailVO =  new OrderDetailVO(product,order,customer);
//      System.out.println(orderDetailVO);
//      return JSONObject.toJSONString(orderDetailVO);
        return result;
    }
    public String handlerHotKey(Integer orderId , BlockException exception){
        return "目前订单请求过多，请稍后访问";
    }
    public String  saveOrderHot(BlockException exception){
        return "目前订单添加请求请求过多，请稍后访问";
    }

}
