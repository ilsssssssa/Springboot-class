package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Override
  public ResponseEntity<ApiResp<UserPostDTO>> getUser(int userId)
      throws ResourceNotFound {
    // 1. User Service
    // 2. Post Service
    // 3. relate the user and post
    // 4. set DTO object and return
    Optional<UserPostDTO> userPostDTO = userService.getUsers().stream() //
        .filter(e -> e.getId() == userId) //
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e, posts);
        }).findFirst();

    if (userPostDTO.isPresent()) {
      ApiResp<UserPostDTO> apiResp = ApiResp.<UserPostDTO>builder() //
          .code(Syscode.OK.getCode()) //
          .message(Syscode.OK.getMessage()) //
          .data(userPostDTO.get()) //
          .build();
      return ResponseEntity.ok(apiResp); // ResponseEntity.ok() -> http status = 200
    }

    // return ResponseEntity.noContent().build(); // ResponseEntity.noContent() -> http status = 204
    throw new ResourceNotFound(Syscode.NOTFOUND);
  }

  @Override
  public UserCommentDTO getUserComments(int userId) {
    return null;
  }

}
