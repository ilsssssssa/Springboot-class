package com.vtxlab.bootcamp.bootcampjavadto.dto;

public class CatDto {
  
  
  private String description; // "Cat Name: John, Cat Age: 1"

  private String logo;

  public CatDto(String description, String logo) {
    this.description = description;
    this.logo = logo;
  }
}
