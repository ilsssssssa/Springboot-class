package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {

  Cat getCatFromStaticMemory(int index);

  void setCatToStaticMemory(int index, Cat cat);
  
}
