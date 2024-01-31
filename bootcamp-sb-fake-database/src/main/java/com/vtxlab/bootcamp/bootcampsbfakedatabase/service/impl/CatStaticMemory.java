package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Service
// @Component <- can replace @Service // ask someone to NEW OBJ = Bean
// Create an objext of this class
public class CatStaticMemory implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  // @Override
  // public Cat getCatFromStaticMemory(int index) {
  // return CatDatabase.getCat(index);
  // }

  // @Override
  // public Cat setCatToStaticMemory(int index, Cat cat) {
  // CatDatabase.setCat(index, cat);
  // return cat;
  // }

  @Override
  public Cat getCat(int index) {
    return CatDatabase.getCat(index);
  }

  @Override
  public Cat setCat(int index, Cat cat) {
    return CatDatabase.setCat(index, cat);
  }

  @Override
  public Cat updateCat(int index, Cat cat) {
    if (getCat(index) == null)
      return null;
    return setCat(index, cat);
  }

  @Override
  public Cat patchCatName(int index, String name) {
    Cat cat = getCat(index);
    if (cat == null)
      return null;
    cat.setName(name);
    return cat;
  }

  @Override
  public Cat patchCatAge(int index, int age) {
    Cat cat = getCat(index);
    if (cat == null)
      return null;
    cat.setAge(age);
    return cat;
  }

  @Override
  public Cat deleteCat(int index) {
    Cat deleted = getCat(index);
    if (deleted == null)
      return null;
    setCat(index, null);
    return deleted;
  }



}


