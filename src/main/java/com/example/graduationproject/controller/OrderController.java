package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("add/order/by/json")
    public Integer addOrder(Order order){
        return orderService.addOrder(order);
    }

    @DeleteMapping("delete/order/by/json")
    public Integer delOrder(Integer bookId){
        return orderService.delOrder(bookId);
    }

    @PutMapping("update/order/by/json")
    public Integer updOrder(Order order){
        return orderService.updOrder(order);
    }

    @GetMapping("get/order/by/json")
    public SzpJsonResult selOrder(Integer userId){
        return SzpJsonResult.ok(orderService.selOrder(userId));
    }
}
