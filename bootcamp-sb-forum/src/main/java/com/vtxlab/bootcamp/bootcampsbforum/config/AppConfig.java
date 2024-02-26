package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.RedisHelper;

// Library (dependency) or your own classes -> object (bean) -> Spring context
@Configuration
public class AppConfig {

  @Bean // 將死物new出黎
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ModelMapper modelMapper() { // java to java // 通常用於將DTO（Data Transfer Object）轉換為Entity對象
    return new ModelMapper();
  }

  @Bean
  RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    // Jackson2JsonRedisSerializer<Object> serializer =
    // new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);
    // redisTemplate.setValueSerializer(serializer);
    return redisTemplate;
  }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisHelper(factory, objectMapper);
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
