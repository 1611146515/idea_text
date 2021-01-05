package com.example.demo.dao;

import com.example.demo.entity.Colu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColuMapper {

    void insert(Colu colu);

    void delete_content(Integer column_id);

    void delete(Integer id);

    void update(Colu colu);

    List<Colu> select_data();

}
