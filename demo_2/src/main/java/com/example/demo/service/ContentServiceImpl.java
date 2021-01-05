package com.example.demo.service;

import com.example.demo.dao.ContentMapper;
import com.example.demo.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentMapper contentMapper;

    //增
    @Override
    public void insert(Content content) {
        contentMapper.insert(content);
    }


    //删
    @Override
    public void delete(Integer id) {
        contentMapper.delete(id);
    }

    //改
    @Override
    public void update(Content content) {
        contentMapper.update(content);
    }

    //查
    @Override
    public List<Content> select_data() {
        List<Content> contentList = contentMapper.select_data();
        return contentList;
    }

}
