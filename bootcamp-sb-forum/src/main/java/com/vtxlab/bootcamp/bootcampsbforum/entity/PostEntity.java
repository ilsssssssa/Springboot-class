package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Posts")
@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
// @ToString -> serialization issue
@Builder // Don't use builder in Entity
public class PostEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generation
  private Long id;
  private String title;
  private String body;
  
  @ManyToOne 
  @JoinColumn(name = "user_id", referencedColumnName = "ID") // (FK) table to column name 
  @JsonBackReference
  private UserEntity user; // object reference

}
// heap
// UserEntity userEntity = new UserEntity(xxx)
// postEntities.setUser(userEntity)
// userEntity.setPosts(postEntities);