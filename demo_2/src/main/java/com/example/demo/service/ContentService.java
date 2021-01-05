package com.example.demo.service;

import com.example.demo.entity.Content;

import java.util.List;

public interface ContentService {

    //增
    void insert(Content content);

    //删
    void delete(Integer id);

    //改
    void update(Content content);

    //查
    List<Content> select_data();

}
