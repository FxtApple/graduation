package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.UserDao;
import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;
import com.example.graduationproject.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Integer addUser(AddUserRequest addUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(addUserRequest,user);
        return userDao.addUser(user);
    }

    @Override
    public String delUser(Long phoneNumber,String password) {
        if (login(phoneNumber,password)==true){
            userDao.delUser(phoneNumber);
            return "用户注销成功";
        }else{
            return "账号或密码有误，请重新输入";
        }
    }

    @Override
    public String updUser(User user) {
        if(login(user.getPhoneNumber(),user.getPassword())==true){
            if(userDao.updUser(user)==1){
                return "修改成功";
            }else{
                return "修改失败";
            }
        }else{
            return "账户或密码不正确";
        }
    }

    @Override
    public List<User> selUser(String name, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<User> users = userDao.selUser(name);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        log.info("allUsers-{}",users);
        log.info("userList<User>-{}",pageInfo.getList());
        log.info("pageSize-{},pageNumber-{}",pageNumber,pageSize);
        return pageInfo.getList();
    }

    @Override
    public boolean login(Long usernumber,String password) {
        return userDao.login(usernumber,password);
    }
}
