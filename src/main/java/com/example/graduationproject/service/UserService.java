package com.example.graduationproject.service;

import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;

import javax.naming.ldap.LdapName;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface UserService {
    Integer addUser(AddUserRequest addUserRequest);

    String delUser(Long phoneNumber,String password);

    String updUser(User user);

    List<User> selUser(String name, Integer pageNumber, Integer size);

    boolean login(Long usernumber, String password);
}
