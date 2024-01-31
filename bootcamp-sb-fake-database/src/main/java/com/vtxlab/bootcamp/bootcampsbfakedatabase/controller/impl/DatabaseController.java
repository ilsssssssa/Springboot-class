package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

// @Controller
// @ResponseBody // JSON
@RestController // (@Controller + @ResponseBody)
// Create an object of this class, and put it into spring context
@RequestMapping(value = "/api/v1")

public class DatabaseController implements DatabaseOperation {

  @Autowired // dependency injection 自動裝配 (NEW OBJECT) // Polymorphism 過程
  // + (required = false), our own command, if no object will keep runing but NUll point Exception
  private CatDatabaseService catDatabaseService;

  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseServiceImpl().getCatFromStaticMemory(index);
    return catDatabaseService.getCat(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    // new CatData
    catDatabaseService.setCat(index, new Cat(name, age));
  }

  @Override
  public Cat createCat(int idx, Cat cat) {
    return catDatabaseService.setCat(idx, cat);
  }

  @Override
  public Boolean deleteCat(int idx) {
    return catDatabaseService.deleteCat(idx) != null;
  }

  @Override
  public Cat updateCat(int idx, Cat cat) {
    return  catDatabaseService.updateCat(idx, cat);
  }

  @Override
  public Cat patchCatName(int idx, String name) {
   return catDatabaseService.patchCatName(idx, name);
  }

  @Override
  public Cat patchCatAge(int idx, int age) {
    return catDatabaseService.patchCatAge(idx, age);
  }
}
