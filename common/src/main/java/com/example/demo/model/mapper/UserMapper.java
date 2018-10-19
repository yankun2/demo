package com.example.demo.model.mapper;

import com.example.demo.model.bean.User;
import tk.mybatis.mapper.common.Mapper;
public interface UserMapper extends Mapper<User> {

    /**
     * 根据名字获取用户
     *
     * @param username
     * @return
     */
    User findByUserName(String username);

/*    @Override
    @SelectProvider(
            type = BaseSelectProvider.class,
            method = "dynamicSQL"
    )
    @ResultMap({

    })
    User selectOne(User user);*/

}