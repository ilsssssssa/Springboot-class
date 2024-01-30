package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl.CatDatabaseServiceImpl;

// @Controller
// @ResponseBody // JSON
@RestController // (@Controller + @ResponseBody)
// Create an object of this class, and put it into spring context
@RequestMapping(value = "/api/v1")

public class DatabaseController implements DatabaseOperation {

  @Autowired // dependency injection 自動裝配 (NEW OBJECT) 
  // + (required = false), our own command, if no object will keep runing but NUll point Exception
  private CatDatabaseService catDatabaseService;

  @Override
  public Cat getCat(int index) {
    return catDatabaseService.getCatFromStaticMemory(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    catDatabaseService.setCatToStaticMemory(index, new Cat(name, age));
  }
}
