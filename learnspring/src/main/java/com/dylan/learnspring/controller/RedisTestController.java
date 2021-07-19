package com.dylan.learnspring.controller;

import com.dylan.learnspring.service.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dylan
 * @Date : Created in 10:31 2021/1/6
 * @Description : 测试redis集群
 * @Function :
 */
@RestController
@RequestMapping("redisTest")
public class RedisTestController {
    private static final Logger logger = LoggerFactory.getLogger(RedisTestController.class);

    @Autowired
    RedisService redisService;

    @RequestMapping("setName")
    public boolean setName(String name){
        redisService.set("name", name);
        return redisService.exists("name");
    }

    @RequestMapping("getName")
    public String getName(){
        return redisService.get("name");
    }

    @RequestMapping("publish")
    public String doPublish(String message){
        return redisService.doPublish(message);
    }

}
