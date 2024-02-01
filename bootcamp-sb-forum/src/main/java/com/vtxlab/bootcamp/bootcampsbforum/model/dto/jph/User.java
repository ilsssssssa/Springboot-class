package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
// @Setter
// @AllArgsConstructor // Testing only. Not required for Deserialization.
// @NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder // Testing only. Not required for Deserialization

// List<User> user =
public class User {

  private int id;

  private String name;

  private String username;

  private String email;

  private Address address;

  private String phone;

  private String website;

  private Company company;


  // @Setter
  @Getter
  public static class Address {

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private Location geo;

  }

  // @Setter
  @Getter
  public static class Location {

    private String lat;

    private String lng;

  }

  // @Setter
  @Getter
  public static class Company {

    private String name;

    private String catchPhrase;

    private String bs;

  }

}
