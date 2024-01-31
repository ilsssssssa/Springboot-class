package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {

  // Cat getCatFromStaticMemory(int index);

  // Cat setCatToStaticMemory(int index, Cat cat);

  Cat getCat(int index);

  Cat setCat(int index, Cat cat);

  Cat deleteCat(int index);

  Cat updateCat(int index, Cat cat);

  Cat patchCatName(int index, String name);

  Cat patchCatAge(int index, int age);
}
