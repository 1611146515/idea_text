package com.example.demo.service;

import com.example.demo.entity.Colu;

import java.util.List;

public interface ColuService {

    void insert(Colu colu);

    void delete_content(Integer column_id);

    void delete(Integer id);

    void update(Colu colu);

    List<Colu> select_data();

}
