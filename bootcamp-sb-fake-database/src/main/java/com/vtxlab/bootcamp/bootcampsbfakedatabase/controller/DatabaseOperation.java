package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface DatabaseOperation {

  // 2 ways to define variable from the URI
  // 1. PathVariable
  @GetMapping(value = "/cat/{idx}")
  Cat getCat(@PathVariable(name = "idx") int index);

  // Just practice. Normally, we use PostMapping
  @GetMapping(value = "/cat/index/{index}/name/{name}/age/{age}")
  void setCat(@PathVariable int index, //
      @PathVariable String name, //
      @PathVariable int age);

  //
  @PostMapping(value = "/cat/idx/{idx}")
  Cat createCat(@PathVariable int idx, @RequestBody Cat cat);

  //
  @DeleteMapping(value = "/cat/idx/{idx}") // delete
  Boolean deleteCat(@PathVariable int idx);

  //
  @PutMapping(value = "/cat/idx/{idx}") // put into and replace
  Cat updateCat(@PathVariable int idx, @RequestBody Cat cat);

  //
  @PatchMapping(value = "/cat/idx/{idx}/name/{name}") // update table where id = ?
  Cat patchCatName(@PathVariable int idx, @RequestBody String name);

  //
  @PatchMapping(value = "/cat/idx/{idx}/age/{age}")
  Cat patchCatAge(@PathVariable int idx, @RequestBody int age);


}