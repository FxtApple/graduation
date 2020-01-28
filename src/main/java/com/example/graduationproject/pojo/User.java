package com.example.graduationproject.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String password;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "create_time")
    private Date createTime;

    private Integer age;

    private Short sex;

    /**
     * 0:truue
1:false

     */
    private Short isvip;

    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 用户-0 管理员-1
     */
    private Integer mark;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return phone_number
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return sex
     */
    public Short getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * 获取0:truue
1:false

     *
     * @return isvip - 0:truue
1:false

     */
    public Short getIsvip() {
        return isvip;
    }

    /**
     * 设置0:truue
1:false

     *
     * @param isvip 0:truue
1:false

     */
    public void setIsvip(Short isvip) {
        this.isvip = isvip;
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取用户-0 管理员-1
     *
     * @return mark - 用户-0 管理员-1
     */
    public Integer getMark() {
        return mark;
    }

    /**
     * 设置用户-0 管理员-1
     *
     * @param mark 用户-0 管理员-1
     */
    public void setMark(Integer mark) {
        this.mark = mark;
    }
}