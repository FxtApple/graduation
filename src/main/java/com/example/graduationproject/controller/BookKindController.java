package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.BookKind;
import com.example.graduationproject.service.BookKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class BookKindController {
    @Autowired
    BookKindService bookKindService;

    @PostMapping(value = "add/bookKind")
    public Integer addBookKind(BookKind bookKind){
        return bookKindService.addBookKind(bookKind);
    }

    @PostMapping(value = "add/bookToKind")
    public Integer addBookToBookKind(Book book){
        return bookKindService.addBookToBookKind(book);
    }

    @DeleteMapping(value = "delete/bookKind")
    public Integer delBookKind(Integer id){
        return bookKindService.delBookKind(id);
    }

    @PutMapping(value = "update/bookKind")
    public Integer updBookKind(BookKind bookKind){
        return bookKindService.updBookKind(bookKind);
    }

    @GetMapping(value = "get/bookKind")
    public SzpJsonResult<BookKind> getBookKind(String name){
        return SzpJsonResult.ok(bookKindService.selBookKind(name));
    }
}
