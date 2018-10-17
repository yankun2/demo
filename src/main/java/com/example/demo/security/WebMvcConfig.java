package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: yakun
 * @Date: 2018年8月16日 12:55:00
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*
             映射指定的urlpath到对应的视图，等价于
             @RequestMapping("/login")
             public String login() {
                 return "login";
             }
         */
        registry.addViewController("/login").setViewName("login");
    }
}
