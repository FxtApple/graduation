package com.example.graduationproject;

import com.example.graduationproject.dao.CommentDao;
import com.example.graduationproject.service.UserOrderCommentShipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class graduationprojectApplicationTests {

    @Autowired
    CommentDao commentDao;
    @Autowired
    UserOrderCommentShipService userOrderCommentShipService;

    @Test
    void contextLoads() {
        Comment comment = new Comment();
        Order order = new Order();
        comment.setUserId(1000);
        comment.setBookId(1);
        comment.setContent("hgeusahg");
        order.setId(1);
        order.setUserId(1000);
        order.setBookId(1);
        order.setIsbought((short) 0);
        order.setMount(1);
        //将评论插入
        System.out.println("接下来插入评论");
        Integer result =  commentDao.addComment(comment);
        System.out.println(result);
        UserOrderCommentShip userOrderCommentShip = new UserOrderCommentShip();

        //如果插入评论成功，插入用户订单评论表
        if(result==1){
            userOrderCommentShip.setUserId(comment.getUserId());
            userOrderCommentShip.setOrderId(order.getId());
            Integer result1 = userOrderCommentShipService.addUOCShip(userOrderCommentShip);
            System.out.println(result1 + "\n" + "--------------------------------" + "\n");
            System.out.println(userOrderCommentShip);
        }

        /*SzpJsonResult<UserOrderCommentShip> szpJsonResult = new SzpJsonResult<UserOrderCommentShip>();
        szpJsonResult.ok(szpJsonResult);
        if(userOrderCommentShipService.addUOCShip(userOrderCommentShip)==1){
            return szpJsonResult;
        }else{
            return null;
        }*/
    }

}
