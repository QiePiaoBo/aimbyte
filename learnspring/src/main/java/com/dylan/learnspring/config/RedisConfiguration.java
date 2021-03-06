package com.dylan.learnspring.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * @author Dylan
 * @Date : 2021/8/16 - 18:07
 * @Description :
 * @Function :
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    @Bean
    public CacheManager myCacheManager(RedisConnectionFactory redisConnectionFactory){

        return RedisCacheManager.create(redisConnectionFactory);
    }

    @Bean
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder = new StringBuilder();
                if (params.length > 0){
                    for (int i = 0; i < params.length; i++) {
                        stringBuilder.append(params[i].toString());
                        stringBuilder.append("_");
                    }
                    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("_"));
                }
                return params.length > 0 ? method.getName() + "?" + stringBuilder : method.getName();
            }
        };
    }


    /**
     * redisTemplate????????????
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // ??????????????????
        template.setConnectionFactory(factory);
        // ??????Jackson2JsonRedisSerializer??????????????????????????????redis???value????????????????????????JDK?????????????????????
        Jackson2JsonRedisSerializer jacksonSerial = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        // ???????????????????????????field set get????????????????????????ANY????????????public???private
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // ????????????????????????????????????????????????final????????????final???????????????????????????
        objectMapper.activateDefaultTyping(new DefaultBaseTypeLimitingValidator(),ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSerial.setObjectMapper(objectMapper);
        // ?????????json?????????
        template.setValueSerializer(jacksonSerial);
        // key??????StringRedisSerializer??????????????????
        template.setKeySerializer(new StringRedisSerializer());
        // ??????hash key ??? value ???????????????
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSerial);
        return template;
    }


    /**
     * ???hash????????????????????????
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForHash();
    }


    /***
     * ???redis???????????????????????????
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForValue();
    }


    /**
     * ??????????????????????????????
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForList();
    }


    /**
     * ????????????????????????????????????
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForSet();
    }


    /**
     * ????????????????????????????????????
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForZSet();
    }


}
