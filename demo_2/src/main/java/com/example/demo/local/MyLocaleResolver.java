package com.example.demo.local;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义区域信息解析器（通过url请求头，带来区域信息），用来替换掉默认的，用于国际化。
 * 但是要记住，要将其添加到容器中
 *
 * 原理：国际化Locale（区域信息对象）；LocaleResolver（获取区域信息对象）；
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver  {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
