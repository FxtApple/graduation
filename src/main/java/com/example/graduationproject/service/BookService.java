package com.example.graduationproject.service;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.AddBookRequest;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface BookService {
    /**
     * 管理员
     * @param addBookRequest
     * @return
     */
    String addBook(AddBookRequest addBookRequest);

    String addBookList(List<Book> books);
    /**
     * 管理员
     * @param id
     * @return
     */
    Integer delBook(Integer id);
    /**
     * 管理员
     * @param addBookRequest
     * @return
     */
    String updBook(AddBookRequest addBookRequest);

    /**
     * 管理员
     * @param mount
     * @return
     */
    List<Book> selBook(Integer mount);

    /**
     * 读者
     * @param name
     * @return
     */
    List<Book> selBook(String name,Integer pageNumber,Integer pageSize);
}
