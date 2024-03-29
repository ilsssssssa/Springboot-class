package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString // -> serialization issue
@Builder
// @Builder // Don't use Builder in Entity
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generated
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  @Column(name = "ADDRESS_LAT")
  private String addrLat;
  @Column(name = "ADDRESS_LNG")
  private String addrLong;
  @Column(name = "COMPANY_NAME")
  private String companyName;
  @Column(name = "COMPANY_CATCH_PHRASE")
  private String companyCatchPhrase;
  @Column(name = "COMPANY_BUSINESS_SERVICE")
  private String companyBusService;
  
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // serialization
  @JsonManagedReference
  private List<PostEntity> posts = new ArrayList<>();

}