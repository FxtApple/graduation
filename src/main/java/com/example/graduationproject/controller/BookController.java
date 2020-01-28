package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.AddBookRequest;
import com.example.graduationproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("add/book/onebyone")
    public String addBookByJson(@RequestBody AddBookRequest addBookRequest){
        return bookService.addBook(addBookRequest);
    }

    @PostMapping("add/book/byList")
    public String addBookByList(@RequestBody List<Book> books){
        return bookService.addBookList(books);
    }


    @DeleteMapping("delete/book/by/json")
    public Integer delBook(@PathVariable("id") Integer id){
        return bookService.delBook(id);
    }


    @PutMapping("update/book/by/json")
    public String updBook(@RequestBody AddBookRequest addBookRequest){
        return bookService.updBook(addBookRequest);
    }

    @GetMapping("get/book/by/name")
    public SzpJsonResult<Book> selBook(String name, Integer pageNumber, Integer pageSize){
        return SzpJsonResult.ok(bookService.selBook(name,pageNumber,pageSize));
    }

    @GetMapping("select/book/by/json")
    public SzpJsonResult<Book> getbook(@PathVariable("mount") Integer mount){
        return SzpJsonResult.ok(bookService.selBook(mount));
    }

}
