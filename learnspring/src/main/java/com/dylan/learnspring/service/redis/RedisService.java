package com.dylan.learnspring.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Redis集群可用
 */
@Service
public class RedisService {

    @Autowired(required = false)
    private StringRedisTemplate redisTemplate;

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";//毫秒
    private static final String EXPIRE_TIME_EX = "EX"; // 秒
    private static final Long RELEASE_SUCCESS = 1L;
    private static final long WEEK_SECONDS = 7 * 24 * 60 * 60; //一周有多少秒


    /**
     * 将 key，value 存放到redis数据库中，默认设置过期时间为一周
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value.toString(), WEEK_SECONDS, TimeUnit.SECONDS);
    }

    /**
     * 将 key，value 存放到redis数据库中，设置过期时间单位是秒
     *
     * @param key
     * @param value
     * @param expireTime
     */
    public  void set(String key, Object value, long expireTime) {
        redisTemplate.opsForValue().set(key, value.toString(), expireTime, TimeUnit.SECONDS);
    }

    /**
     * 设置超时时间
     * @param key
     * @param expire
     * @return
     */
     public boolean expire(String key, long expire) {
          Boolean flag = redisTemplate.expire(key, expire, TimeUnit.SECONDS);
          return flag;
    }

    /**
     * 判断 key 是否在 redis 数据库中
     *
     * @param key
     * @return
     */
    public  boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 获取 key 对应的字符串
     * @param key
     * @return
     */
    public  String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除 key 对应的 value
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }
    /**
     * 获取字符串为前缀的KEY列表
     * @param key
     */
    public Set<String>  keys(String key) {
        return redisTemplate.keys(key);
    }
    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    public Long incr(String key, long delta) throws Exception {
        if (delta <= 0) {
        	throw new Exception("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(大于0)
     * @return
     */
    public Long decr(String key, long delta) throws Exception {
        if (delta <= 0) {
        	throw new Exception("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * 创建锁  最简单方法
     *
     * @param key         锁的Key
     * @param value       值(随便写毫无意义)
     * @param releaseTime 锁过期时间 防止死锁
     * @return
     */
    public boolean lock(String key, String value, long releaseTime) {
        // 尝试获取锁
        Boolean boo = redisTemplate.opsForValue().setIfAbsent(key, value, releaseTime, TimeUnit.SECONDS);
        // 判断结果
        return boo != null && boo;
    }

    /**
     * 根据key删除锁  最简单方法
     *
     * @param key
     */
    public void deleteLock(String key) {
        // 删除key即可释放锁
        redisTemplate.delete(key);
    }

    /**
     * 尝试获取分布式锁
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     * 待确认删除
     */
    @Deprecated
    public  boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
    	return lock(lockKey, requestId, (long) expireTime);
    }

    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     * 待确认删除
     */
    public  boolean releaseDistributedLock(String lockKey, String requestId) {
        try {
            deleteLock(lockKey);
        }catch (Exception e){
            return false;
        }
    	return true;
    }

    /**
     * 获取唯一Id
     * @param key
     * @param hashKey
     * @param delta 增加量（不传采用1）
     * @return
     * @throws Exception
     */
    public Long incrementHash(String key,String hashKey,Long delta) throws Exception {
        try {
            if (null == delta) {
                delta=1L;
            }
            return redisTemplate.opsForHash().increment(key, hashKey, delta);
        } catch (Exception e) {//redis宕机时采用uuid的方式生成唯一id
            int first = new Random(10).nextInt(8) + 1;
            int randNo=UUID.randomUUID().toString().hashCode();
            if (randNo < 0) {
                randNo=-randNo;
            }
            return Long.valueOf(first + String.format("%16d", randNo));
        }
    }
}