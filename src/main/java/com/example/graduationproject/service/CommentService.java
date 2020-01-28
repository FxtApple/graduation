package com.example.graduationproject.service;

import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.request.AddCommentRequest;
import com.example.graduationproject.request.AddOrderRequest;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */

public interface CommentService {
    public Integer addComment(AddCommentRequest addCommentRequest, AddOrderRequest addOrderRequest);

    public Integer addUOCShip(Comment comment, Order order);

    Integer delComment(Integer userId);

    Integer updComment(Comment comment);

    List<Comment> selComment(Integer bookId);
}
