package com.example.demo.controller;

import com.example.demo.entity.Colu;
import com.example.demo.entity.Content;
import com.example.demo.service.ColuService;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ColumnController {

    @Autowired
    private ColuService coluService;
    @Autowired
    private ContentService contentService;

    /**
     * 增（栏目）
     */
    @PostMapping("/col")
    public String insert_col(Colu colu){
        coluService.insert(colu);
        return "redirect:/col";
    }

    /**
     * 增（内容）
     */
    @PostMapping("/content")
    public String insert_content(Content content){
        contentService.insert(content);
        return "redirect:/col";
    }

    /**
     * 删（栏目）
     */
    @DeleteMapping("/col")
    public String delete_col(int id){
        coluService.delete_content(id);                 //关联删除
        coluService.delete(id);
        return "redirect:/col";
    }

    /**
     * 删（内容）
     */
    @DeleteMapping("/content")
    public String delete_content(int id){
        contentService.delete(id);
        return "redirect:/col";
    }

    /**
     * 改（栏目）
     */
    @PutMapping("/col")
    public String update_col(Colu colu){
        coluService.update(colu);
        return "redirect:/col";
    }

    /**
     * 改（内容）
     */
    @PutMapping("/content")
    public String update_content(Content content){
        contentService.update(content);
        return "redirect:/col";
    }

    /**
     * 查
     */
    @GetMapping("/col")
    public String query(Map<String,Object> map, HttpSession session){
        List<Content> contentList = contentService.select_data();
        map.put("content",contentList);
        List<Colu> coluList = coluService.select_data();
        map.put("colu",coluList);

        //获取栏目表（Colu）的id，封装为List集合
        List<Integer> id_list = new ArrayList<>();
        for(Colu co:coluList){
            id_list.add(co.getId());
        }
        //添加到Session域对象中
        session.setAttribute("id_list",id_list);
        return "welcome";
    }

}
