package com.example.demo.service;

import com.example.demo.dao.ColuMapper;
import com.example.demo.entity.Colu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColuServiceImpl implements ColuService {

    @Autowired
    private ColuMapper coluMapper;

    @Override
    public void insert(Colu colu) {
        coluMapper.insert(colu);
    }

    //关联删除
    @Override
    public void delete_content(Integer column_id) {
        coluMapper.delete_content(column_id);
    }
    @Override
    public void delete(Integer id) {
        coluMapper.delete(id);
    }

    @Override
    public void update(Colu colu) {
        coluMapper.update(colu);
    }

    @Override
    public List<Colu> select_data() {
        List<Colu> coluList = coluMapper.select_data();
        return coluList;
    }

}
