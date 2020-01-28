package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.UserMapper;
import com.example.graduationproject.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class UserDao {
    @Autowired
    UserMapper userMapper;

    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    public boolean login(Long phoneNumber,String password) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phoneNumber",phoneNumber)
                .andEqualTo("password",password);
        List<User> result = userMapper.selectByExample(example);
        if(result!=null){
            return true;
        }else {
            return false;
        }
    }

    public Integer delUser(Long phoneNumber) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phoneNumber",phoneNumber);
        return userMapper.deleteByExample(example);
    }

    public Integer updUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> selUser(String name) {
        Example example = new Example(User.class);
        example.createCriteria().andLike("nickName","%" + name + "%");
        return userMapper.selectByExample(example);
    }
}
