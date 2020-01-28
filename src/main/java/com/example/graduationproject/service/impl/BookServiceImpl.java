package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.BookDao;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.AddBookRequest;
import com.example.graduationproject.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public String addBook(AddBookRequest addBookRequest) {
        List<Book> list = new ArrayList<>();
        int i;
        for (i = 0; i < 100; i++) {
            Book book1 = new Book();
            book1.setBookName(addBookRequest.getBookName());
            book1.setWriterName(addBookRequest.getWriterName());
            book1.setImgUrl(addBookRequest.getImgUlr());
            book1.setMount(addBookRequest.getMount());
            book1.setPrice(addBookRequest.getPrice());
            list.add(book1);
        }
        Long start1 = System.currentTimeMillis();
        Integer result = 0;
        for(Book book1:list){
            result = bookDao.addBook(book1);
            if(result==1){
                result++;
            }
        }
        Long end1 = System.currentTimeMillis();
        log.info("插入数据所需时间-{}",end1-start1);
        if(result == (Integer) i) {
            return "添加图书成功";
        }else{
            return "添加图书失败";
        }
    }

    @Override
    public String addBookList(List<Book> books) {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book1 = books.get(i);
            book1.setBookName(book1.getBookName());
            book1.setWriterName(book1.getWriterName());
            book1.setImgUrl(book1.getImgUrl());
            book1.setMount(book1.getMount());
            book1.setPrice(book1.getPrice());
            list.add(book1);
        }
        Long start2 = System.currentTimeMillis();
        Integer result = bookDao.addBookList(list);
        Long end2 = System.currentTimeMillis();
        log.info("插入数据所需时间-{}",end2-start2);
        if(result == 1) {
            return "添加图书成功";
        }else{
            return "添加图书失败";
        }
    }

    @Override
    public Integer delBook(Integer id) {
        return bookDao.delBook(id);
    }

    @Override
    public String updBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(book,addBookRequest);
        if(bookDao.updBook(book)==1){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }


    /**
    根据书名或者作者姓名查询相关书籍
     */
    @Override
    public List<Book> selBook(String name,Integer pageNumber,Integer pageSize) {
        //开始分页，必须写在上面
        PageHelper.startPage(pageNumber,pageSize);
        List<Book> all = bookDao.selBook(name);
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        log.info("all-{}",all);
        log.info("pageInfo.getList()-{}",pageInfo.getList());
        log.info("pagesize-{},pageNumber-{}",pageSize,pageNumber);
        return pageInfo.getList();
    }

    /**
     * 查找出数量为0值得书
     * @param mount
     * @return
     */
    @Override
    public List<Book> selBook(Integer mount) {
       return bookDao.selBook(mount);
    }
}
