package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.pojo.UserOrderCommentShip;
import com.example.graduationproject.request.AddCommentRequest;
import com.example.graduationproject.request.AddOrderRequest;
import com.example.graduationproject.service.CommentService;
import com.example.graduationproject.service.OrderService;
import com.example.graduationproject.service.UserOrderCommentShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserOrderCommentShipService userOrderCommentShipService;
    @Autowired
    OrderService orderService;

    @PostMapping("add/comment/by/json")
    public SzpJsonResult<UserOrderCommentShip> addComment(@RequestBody AddCommentRequest addCommentRequest, @RequestBody AddOrderRequest addOrderRequest) {
        Integer result =  commentService.addComment(addCommentRequest,addOrderRequest);
        return SzpJsonResult.ok(result);
    }


    @DeleteMapping("delete/comment/by/json")
    public Integer delComment(@PathVariable("id")Integer userId){
        return commentService.delComment(userId);
    }

    @PutMapping("update/comment/by/json")
    public Integer updComment(Comment comment){
        return commentService.updComment(comment);
    }

    @GetMapping("get/comment/by/json")
    public SzpJsonResult<Comment> selComment(@PathVariable("id") Integer bookId){
        return SzpJsonResult.ok(commentService.selComment(bookId));
    }
}
