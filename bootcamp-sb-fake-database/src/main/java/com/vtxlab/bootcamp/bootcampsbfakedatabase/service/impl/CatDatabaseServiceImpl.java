package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Service
// Create an objext of this class
public class CatDatabaseServiceImpl implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  @Override
  public Cat getCatFromStaticMemory(int index) {
    return CatDatabase.getCat(index);
  }

  @Override
  public void setCatToStaticMemory(int index, Cat cat) {
    CatDatabase.setCat(index, cat);
  }

}
