package com.example.graduationproject.service;

import com.example.graduationproject.pojo.Order;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface OrderService {
    Integer addOrder(Order order);

    Integer delOrder(Integer bookId);

    Integer updOrder(Order order);

    List<Order> selOrder(Integer userId);
}
