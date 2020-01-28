package com.example.graduationproject.controller;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author:Fengxutong
 * @Date:2020/1/11
 * @Description:小冯同学写点注释吧！
 */
@Slf4j
@RestController
public class HelloController {

    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuffer stringBuffer = new StringBuffer();

    HashMap hashMap = new HashMap<String,Integer>();
    Hashtable<String,Integer> hashtable = new Hashtable();


    @GetMapping
    public String getHello(@RequestParam(name = "content",required = false) String content){
        return content;
    }

    public void test(){
        System.out.println(hashMap.put("aihgea",null));
    }



}
