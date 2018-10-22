package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author admin
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    /**
     * 根据用户姓名获取数量
     * @param user s
     * @return int
     */
    public int countByExample(User user) {
        //下面是一个完整的案列
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName",user.getUserName());
        int count = userMapper.selectCountByExample(example);
       // 相当于：select count ( *)from user where user_name = 'joe';
        return count;
    }

    /**
     * 根据用户姓名删除
     * @param user
     * @return int
     */
    public int deleteByExample(User user) {
        //下面是一个完整的案列
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName",user.getUserName());
        int count = userMapper.deleteByExample(example);
        // 相当于：delete  from user  where user_name = 'joe';
        return count;
    }

    /**
     * 根据用户姓名更新密码
     * @param userName
     * @param password
     * @return int
     */
    public int updateByExample(String userName, String password) {
        //下面是一个完整的案列
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName",userName);

        User user = new User();
        user.setPassword(password);
        int count = userMapper.updateByExample(user,example);
        // 相当于：update user set password='123456' where username='joe';
        return count;
    }

}
