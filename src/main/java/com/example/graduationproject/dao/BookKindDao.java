package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.BookKindMapper;
import com.example.graduationproject.mapper.BookMapper;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.BookKind;
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
public class BookKindDao {
    @Autowired
    BookKindMapper bookKindMapper;

    @Autowired
    BookMapper bookMapper;
    public Integer addBookKind(BookKind bookKind) {
        return bookKindMapper.insert(bookKind);
    }

    public Integer addBookToBookKind(Book book) {
        return bookMapper.insert(book);
    }

    public Integer delBookKind(Integer id) {
        return bookKindMapper.deleteByPrimaryKey(id);
    }

    public Integer updBookKind(BookKind bookKind) {
       return bookKindMapper.updateByPrimaryKeySelective(bookKind);
    }

    public List<BookKind> selBookKind(String name) {
        Example bookKindExample = new Example(BookKind.class);
        bookKindExample.createCriteria().andLike("kindName","%"+name+"%");
        return bookKindMapper.selectByExample(bookKindExample);
    }

}
