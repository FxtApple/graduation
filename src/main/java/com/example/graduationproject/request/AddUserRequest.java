package com.example.graduationproject.request;

import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/1/11
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddUserRequest {
    private String usernumber;

    private String password;

    private String nickName;

    private Integer age;

    private Short sex;

    private Short isvip;
}
