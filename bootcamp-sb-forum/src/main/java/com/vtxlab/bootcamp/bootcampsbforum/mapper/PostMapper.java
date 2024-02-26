package com.vtxlab.bootcamp.bootcampsbforum.mapper;

import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.request.PostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;

// When server starts,
// Spring ensures modelMapper is ready before creating GovMapper object
@Component // -> Bean
public class PostMapper {

  public PostEntity mapEntity(PostRequestDTO dto) {
    return new PostEntity(null, //
        dto.getTitle(), //
        dto.getBody(), //
        null);
  }

}