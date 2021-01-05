package com.example.demo.config;


import com.example.demo.interceptor.MyInterceptor;
import com.example.demo.local.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration              //表明该类为一个配置类
public class UserConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置多个mapping映射规则，多个Mapping都可以映射到指定页面（login.html）
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/log").setViewName("login");

//        registry.addViewController("/insert_col").setViewName("insert_col");
//        registry.addViewController("/delete_col").setViewName("delete_col");
//        registry.addViewController("/update_col").setViewName("update_col");
//
//        registry.addViewController("/insert_content").setViewName("insert_content");
//        registry.addViewController("/delete_content").setViewName("delete_content");
//        registry.addViewController("/update_content").setViewName("update_content");
    }

    /**
     * 将自定义的区域信息解析器添加到容器中
     */
    @Bean
    public LocaleResolver localeResolver(){                             //注意：该方法名称不可乱写
        return new MyLocaleResolver();
    }

    /**
     * 配置拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")             //拦截所有
                .excludePathPatterns("/login","/log","/welcome");                       //排除哪些页面
        //静态资源不用管。springboot已经做好了静态资源映射
    }

}
