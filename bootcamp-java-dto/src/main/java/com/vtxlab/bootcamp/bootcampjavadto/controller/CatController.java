package com.vtxlab.bootcamp.bootcampjavadto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.vtxlab.bootcamp.bootcampjavadto.dto.CatDto;
import com.vtxlab.bootcamp.bootcampjavadto.model.Cat;
import com.vtxlab.bootcamp.bootcampjavadto.service.CatService;

public class CatController {

  public CatDto getCat() {
    Cat cat = new CatService().getCat();
    String description =
        "Cat Name:" + cat.getName() + ", Cat Age:" + cat.getAge();
    CatDto catDto = new CatDto(description, "Apple");

    return catDto;
  }

  public Map<String, Integer> getCats() { // String -> name, Integer -> age
    // call getCats();
    CatService catService = new CatService();
    List<Cat> cats = catService.getCats();
    // convert cats to Map<String, Integer>
    Map<String, Integer> catMap = new HashMap<>();
    for (Cat c : cats) {
      catMap.put(c.getName(), c.getAge());
    }
    return catMap;
  }

  // Checked Exception Handler
  public List<Cat> getCatList() {
    try {
      return new CatService().getCatList();
    } catch (Exception e) {
      return null;
    }
  }

}