package com.example.demo.controller;

import com.example.demo.entity.Colu;
import com.example.demo.entity.Content;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ConfigController {

    /**
     *  registry.addViewController("/insert_col").setViewName("insert_col");
     *         registry.addViewController("/delete_col").setViewName("delete_col");
     *         registry.addViewController("/update_col").setViewName("update_col");
     *
     *         registry.addViewController("/insert_content").setViewName("insert_content");
     *         registry.addViewController("/delete_content").setViewName("delete_content");
     *         registry.addViewController("/update_content").setViewName("update_content");
     */

    @RequestMapping("/insert_col")
    public String insert_col(@RequestParam(value = "id") Integer id, @RequestParam(value = "statu")Integer statu, Map<String,Object> map){
        if(statu == 0)
            return "redirect:/col";
        map.put("id",id);
        return "insert_col";
    }

    @RequestMapping("/delete_col")
    public String delete_col(@RequestParam(value = "id") Integer id, @RequestParam(value = "statu")Integer statu, Map<String,Object> map){
        if(statu == 0)
            return "redirect:/col";
        map.put("id",id);
        return "delete_col";
    }

    @RequestMapping("/update_col")
    public String update_col(Colu colu, Map<String,Object> map, HttpSession session){               //root用户允许修改statu标记
        int statu = colu.getStatu();
        String username = (String)session.getAttribute("username");
        if(statu == 0 && !username.equals("root"))
            return "redirect:/col";
        map.put("colu",colu);
        return "update_col";
    }



    @RequestMapping("/insert_content")
    public String insert_content(@RequestParam(value = "id") Integer id,Map<String,Object> map){
        map.put("id",id);
        return "insert_content";
    }

    @RequestMapping("/delete_content")
    public String delete_content(@RequestParam(value = "id") Integer id,Map<String,Object> map){
        map.put("id",id);
        return "delete_content";
    }

    @RequestMapping("/update_content")
    public String update_content(Content content, Map<String,Object> map){
        map.put("content",content);
        return "update_content";
    }

}
