package com.vtxlab.bootcamp.bootcampsbfakedatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

  @Bean(name = "tutor")
  String tutorName() {
    return "Vincent";
  }

  @Bean(name = "tutor2")
  String tutorName2() {
    return "Oscar";
  }

  @Bean
  ObjectMapper objectMapper(){
    return new ObjectMapper();
  }

}
