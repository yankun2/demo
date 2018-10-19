//package com.example.demo.security;
//
//import com.example.demo.model.service.impl.CustomUserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
///**
// * @Description: security初始化
// * @Author: yankun
// * @Date: 2018-08-15 14:34
// * */
//@Configuration
////禁用springboot默认的Security配置，配合@Configuration启用自定义配置
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    //注册UserDetailsService 的bean
//    @Bean
//    UserDetailsService customUserService(){
//        return new CustomUserService();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserService()); //user Details Service验证
//
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated() //任何请求,登录后可以访问
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .permitAll() //登录页面用户任意访问
//                .and()
//                .logout().permitAll(); //注销行为任意访问
//
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //解决静态资源被拦截的问题
//        web.ignoring().antMatchers("/**/*.js",
//                "/**/*.css",
//                "/**/*.jpg",
//                "/**/*.png");
//    }
//
//}
