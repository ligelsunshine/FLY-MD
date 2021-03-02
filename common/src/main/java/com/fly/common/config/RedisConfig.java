package com.fly.common.config;

import com.fly.common.utils.YmlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * description: RedisConfig
 * date: 2021/3/1 15:01
 * version: 1.0
 * @author: LIGEL
 */
@PropertySource(value = {"classpath:./redisConfiguration.yml"}, encoding = "UTF-8", factory = YmlPropertySourceFactory.class)
@Configuration
@ConfigurationProperties(prefix = "redis")
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


}
