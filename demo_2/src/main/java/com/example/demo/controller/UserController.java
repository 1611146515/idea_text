package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@ComponentScan(basePackages = {"com.example.demo.service"})
@MapperScan("com.example.demo.dao")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/text")
    public String text(){
        return "测试成功";
    }

    @RequestMapping("/welcome")
    public String welcome(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Map<String,Object> map){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            map.put("msg","用户名密码不能为空");
            return "login";
        }
        List<User> userList = userService.select(username);
        int i = 0;
        for(User user:userList){
            if(user.getPassword().equals(password)) {
                System.out.println("---------"+user.toString()+"--------------");
                i = 1;
            }
        }
        if(i == 1){
            session.setAttribute("username",username);
            //防止表单重复提交，我们可以重定向到欢迎页面（配置类中有 /wel 的映射）
            return "redirect:/col";                                     //直接请求 @GetMapping("/col")
        }
        else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }


}
