/**
 * Copyright ©2016 www.uinpay.cn Technology Co.,Ltd.All Rights Reserved
 * com.tech.test.config.RedisConfig.java Administrator 2016年9月9日
 */
package com.tech.test.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.lang.reflect.Method;

/**
 * @autor: Administrator desc : ...
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	
	@Bean
	public KeyGenerator wiselyKeyGenerator(){
		return new KeyGenerator(){
			
			@Override
			public Object generate(Object target , Method method , Object ... params){
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for(Object obj : params){
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
	
	@Bean
	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate){
		return new RedisCacheManager(redisTemplate);
	}
	
	@Bean
	public RedisTemplate<String , String> redisTemplate(RedisConnectionFactory factory){
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL , JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}
}
