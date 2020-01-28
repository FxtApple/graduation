package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.OrderDao;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public Integer addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public Integer delOrder(Integer bookId) {
        return orderDao.delOrder(bookId);
    }

    @Override
    public Integer updOrder(Order order) {
        return orderDao.updOrder(order);
    }

    @Override
    public List<Order> selOrder(Integer userId) {
        return orderDao.selOrder(userId);
    }
}
