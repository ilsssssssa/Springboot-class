package com.vtxlab.bootcamp.bootcampsbforum.infra;

public class BusinessException extends Exception{ // check exception
  
  private String code;

  public BusinessException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }
  
}
