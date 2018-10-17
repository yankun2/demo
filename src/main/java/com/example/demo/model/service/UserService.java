package com.example.demo.model.service;

import com.example.demo.model.bean.User;

/**
 * @Description: Swagger2配置类
 * @author: yankun
 * @Date: 2018-08-13 16:34
 */
public interface UserService {

    /**
     * 根据id获取用户
     * @param user
     * @return
     */
    User getUserById(User user);

    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findByUserName(String username);
}
