package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.JPHClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

@Service
public class PostJsonPlaceHolder implements PostService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.post}")
  private String postEndpoint;

  @Override
  public List<Post> getPosts() {
    RestTemplate restTemplate = new RestTemplate();
    String postUrl = BcUtil.url(Scheme.HTTPS, domain, postEndpoint);

    try {
      Post[] posts = restTemplate.getForObject(postUrl, Post[].class);
      return Arrays.stream(posts) //
          .collect(Collectors.toList());
    } catch (RestClientException e) {
      throw new JPHClientException(Syscode.JPH_NOT_AVAILABLE);
    }

  }

}