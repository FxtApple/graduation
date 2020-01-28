package com.example.graduationproject.service;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.BookKind;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface BookKindService {
    /**
     * 添加种类
     * */
    Integer addBookKind(BookKind bookKind);

    /**
     * 往种类中添加书籍
     * @param book
     * @return
     */
    Integer addBookToBookKind(Book book);

    Integer delBookKind(Integer id);

    Integer updBookKind(BookKind bookKind);

    List<BookKind> selBookKind(String name);
}
