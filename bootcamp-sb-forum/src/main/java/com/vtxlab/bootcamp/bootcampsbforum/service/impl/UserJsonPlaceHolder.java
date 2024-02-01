package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class UserJsonPlaceHolder implements UserService {

  @Value(value = "${api.jph.domain}")
  private String domain; // jph class ,URL

  @Value(value = "${api.jph.endpoints.user}")
  private String userEndpoint;

  @Override
  public List<User> getUsers() {

    RestTemplate restTemplate = new RestTemplate();

    String userUrl = url(domain, userEndpoint);

    User[] users =restTemplate.getForObject(url(domain, userEndpoint), User[].class);

    return Arrays.stream(users)
      .collect(Collectors.toList());
  }

  private static String url(String domain, String endpoint) {
    
    return UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercaseName()) // = .scheme("https")
        .host(domain) //
        .path(endpoint) //
        .toUriString(); // handle special character, such as : / \
  }

}
