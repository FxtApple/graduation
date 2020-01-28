package com.example.graduationproject.service.impl;


import com.example.graduationproject.dao.CommentDao;
import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.pojo.UserOrderCommentShip;
import com.example.graduationproject.request.AddCommentRequest;
import com.example.graduationproject.request.AddOrderRequest;
import com.example.graduationproject.service.CommentService;
import com.example.graduationproject.service.UserOrderCommentShipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    CommentService commentService;
    @Autowired
    UserOrderCommentShipService userOrderCommentShipService;

    @Override
    public Integer addComment(AddCommentRequest addCommentRequest,AddOrderRequest addOrderRequest) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(addCommentRequest,comment);
        Integer result = commentDao.addComment(comment);
        System.out.println(result);
        if (result == 1) {
            log.info("添加评论-{}",comment);
            UserOrderCommentShip userOrderCommentShip = new UserOrderCommentShip();
            Order order = new Order();
            BeanUtils.copyProperties(addCommentRequest,order);
            return addUOCShip(comment,order);
        }
        return null;
    }

    @Override
    public Integer addUOCShip(Comment comment, Order order) {
        UserOrderCommentShip userOrderCommentShip = new UserOrderCommentShip();
        userOrderCommentShip.setUserId(comment.getUserId());
        userOrderCommentShip.setOrderId(order.getId());
        return userOrderCommentShipService.addUOCShip(userOrderCommentShip);
    }


    @Override
    public Integer delComment( Integer userId) {
        return commentDao.delComment(userId);
    }

    @Override
    public Integer updComment(Comment comment) {
        return commentDao.updComment(comment);
    }

    @Override
    public List<Comment> selComment(Integer bookId) {
        return commentDao.selComment(bookId);
    }
}
