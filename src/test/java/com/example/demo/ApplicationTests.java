package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.bean.User;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        //stringRedisTemplate.opsForValue().set("aa", "1234");
        User user = null;
        List<User> users = Lists.newArrayList();

        for (int i = 0; i < 5; i++) {
            user = new User();
            users.add(user);
        }

        users.stream().forEach(j->System.out.println(JSONObject.toJSONString(j)));


    }
}
