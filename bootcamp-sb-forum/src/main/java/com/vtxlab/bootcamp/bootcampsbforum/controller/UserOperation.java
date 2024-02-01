package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

@Component
public interface UserOperation {
  

  @GetMapping(value = "/users")
  List<User> getUsers();
}