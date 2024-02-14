package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppConfig {

  @Bean
  public RestTemplate restTemplate() { 
    return new RestTemplate(); 
  }

  @Bean
  public ModelMapper modelMapper() { // java to java
    return new ModelMapper();
  }
}
