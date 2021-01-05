package com.example.demo.dao;

import com.example.demo.entity.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    //增
    void insert(Content content);

    //删
    void delete(Integer id);

    //改
    void update(Content content);

    //查
    List<Content> select_data();

}
