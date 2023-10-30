package com.cache.testredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class MyRedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        GenericJackson2JsonRedisSerializer gj2jrs = new GenericJackson2JsonRedisSerializer();
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(StringRedisSerializer.UTF_8);
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(gj2jrs);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(StringRedisSerializer.UTF_8);
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(gj2jrs);
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
