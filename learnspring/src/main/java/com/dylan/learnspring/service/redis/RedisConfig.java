package com.dylan.learnspring.service.redis;//package com.learn.lspring.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author Dylan
// * @Date : Created in 17:23 2021/1/5
// * @Description :
// * @Function :
// */
//@Configuration
//public class RedisConfig extends CachingConfigurerSupport {
//    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(@Autowired(required = false)RedisConnectionFactory factory){
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        setSerializer(template);
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    private void setSerializer(StringRedisTemplate template){
//        @SuppressWarnings({"rawtypes", "unchecked"})
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        template.setHashValueSerializer(stringRedisSerializer);
//        template.setHashKeySerializer(stringRedisSerializer);
//    }
//
//
//}
