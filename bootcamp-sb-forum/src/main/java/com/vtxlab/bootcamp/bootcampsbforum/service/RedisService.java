package com.vtxlab.bootcamp.bootcampsbforum.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User2;


public interface RedisService {

  User2 createUser2(String key, User2 user) throws JsonProcessingException;

  User2 getUser2(String key) throws JsonProcessingException;

}