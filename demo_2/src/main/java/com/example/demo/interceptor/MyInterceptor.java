package com.example.demo.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器（防止未经过登录页面，而直接通过 wel 映射访问欢迎页面）
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * controller方法前进行拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String)request.getSession().getAttribute("username");
        if(username == null || username.equals(null)){                                     //不是通过登录页面进入欢迎页面的就拦截
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/login").forward(request,response);    //重定向到登录页面
            return false;
        }else                                                                               //是通过登录页面进入的欢迎页面的就放行
            return true;
    }

    /**
     * controller方法后进行拦截
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 页面渲染后进行拦截
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
