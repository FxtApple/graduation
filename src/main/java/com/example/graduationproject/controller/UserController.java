package com.example.graduationproject.controller;

import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;
import com.example.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/5
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("add/user/by/json")
    public Integer addUserByJson(@RequestBody AddUserRequest adduserRequest){
        return userService.addUser(adduserRequest);
    }

    @GetMapping("login/by/json")
    public boolean login(@PathVariable("phonenumber") Long phoneNumber,@PathVariable("password") String password){
        return userService.login(phoneNumber,password);
    }

    @DeleteMapping("delete/user/by/json")
    public String delUserByJson(@PathVariable("phoneNumber") Long phoneNumber,@PathVariable("password") String password){
        return userService.delUser(phoneNumber,password);
    }

    @PutMapping("update/user/by/json")
    public String updUserByJson(@RequestBody User user){
        return userService.updUser(user);
    }

    @GetMapping("select/user/by/json")
    public Object[] selUserByJson(@RequestBody String name, Integer pageNumber, Integer size){
        List<User> list = userService.selUser(name,pageNumber,size);
        Object[] s = list.toArray();
        return s;
    }
}
