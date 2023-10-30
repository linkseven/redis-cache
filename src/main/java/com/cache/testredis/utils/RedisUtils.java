package com.cache.testredis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 写入缓存+过期时间
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public boolean set( String key, String value, Long expireTime , TimeUnit timeUnit){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(key,value);
        redisTemplate.expire(key,expireTime,timeUnit);
        return true;
    }

    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public String get(String key){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 批量删除 k-v
     * @param keys
     * @return
     */
    public boolean remove(final String... keys){
        for(String key : keys){
            if(redisTemplate.hasKey(key)){ //key存在就删除
                redisTemplate.delete(key);
            }
        }
        return true;
    }
}

