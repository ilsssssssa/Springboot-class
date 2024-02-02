package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;

public interface GovOperation {

  // 1. no user found
  // 2. user found, but no posts -> empty array of posts
  @GetMapping(value = "/users")
  ResponseEntity<ApiResp<UserPostDTO>> getUser(@RequestParam(value = "id") int userId)
      throws ResourceNotFound;

  // 1. no user found
  // 2. user found, but no comments -> empty array of comments
  @GetMapping(value = "/comments")
  UserCommentDTO getUserComments(@RequestParam int userId);

  // 404 -> request path issue or resource not found
  // 204 -> id not found. Processed the business logic, record not found
}