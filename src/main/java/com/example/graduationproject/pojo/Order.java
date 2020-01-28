package com.example.graduationproject.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "book_id")
    private Integer bookId;

    /**
     * 0:true
1:faluse

     */
    private Short isbought;

    private Integer mount;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return book_id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取0:true
1:faluse

     *
     * @return isbought - 0:true
1:faluse

     */
    public Short getIsbought() {
        return isbought;
    }

    /**
     * 设置0:true
1:faluse

     *
     * @param isbought 0:true
1:faluse

     */
    public void setIsbought(Short isbought) {
        this.isbought = isbought;
    }

    /**
     * @return mount
     */
    public Integer getMount() {
        return mount;
    }

    /**
     * @param mount
     */
    public void setMount(Integer mount) {
        this.mount = mount;
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
}