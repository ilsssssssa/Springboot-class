package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface SpringContextOperation {
  
  @GetMapping(value = "/beans") //noun
  CharSequence[] getBeans();

  @GetMapping(value = "/beans/tutorName")
  public CharSequence getTutorName();
}
