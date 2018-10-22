package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.service.IRedisService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    /**
     * 这个主要是根据redis存储的数据类型需求决定，key一般都是String，但是value可能不一样，一般有两种，String和 Object；
     * 如果k-v都是String类型，我们可以直接用 StringRedisTemplate，这个是官方建议的，也是最方便的，直接导入即用，无需多余配置！
     * 如果k-v是Object类型，则需要自定义 RedisTemplate，在这里我们都研究下！
     */
    @Autowired
    private IRedisService redisService;


    @Resource
    private RedisTemplate<String,User> redisTemplate;


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

    @Test
    public void contextLoad() {
        redisService.set("aa", "12345");
    }

    @Test
    public void redis(){
    /*    User user = new User();
        user.setId(222);
        redisTemplate.opsForValue().set("cc",user);*/

        User user2 =  redisTemplate.opsForValue().get("cc");

        System.out.println(JSONObject.toJSONString(user2)+"'22222222222");



    }


}
