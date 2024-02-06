package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse<T> {
  
  private String code;

  private String message;

  private T data;

  public ApiResponse(String code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

}
