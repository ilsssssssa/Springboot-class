package com.vtxlab.bootcamp.bootcampsbforum.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

@Repository // Bean // Controller // Sever
public interface UserRepository extends JpaRepository<User, Long> {

  // Query Methods
  // select * from users where username = ?
  User findByUsername(String username);

  List<User> findAllByEmailAndPhoneOrderByEmailDesc(String email, String phone);

  List<User> findAllByEmailOrPhone(String email, String phone, Sort sort);

  // JPQL // @Query default by false // 實體對象進行查詢，使用的是類和屬性的名稱
  // 使用的是 Entity 的物件替代了原本的 Table // < > = findbyfield
  @Query("SELECT e FROM User e WHERE CAST(e.addrLat AS double) > :lat")
  List<User> findAllByAddrLatGreaterThan(@Param("lat") Double latitude);

  // Native SQL // 使用傳統的SQL語法，直接操作數據庫表和列 注意不同數據庫之間的語法差異
  // 使用了原本的 Table // 將參數、條件帶入後就直接送到 SQL 執行
  @Query(
      value = "SELECT count(1) FROM USERS u WHERE lower (u.name) LIKE lower(concat(:prefix, %))",
      nativeQuery = true)
  Long countUserByNameStartWith(String prefix);

  // Hibernate (implementation class) -> Bean -> Spring Context // Database interaction
  // Objective: Implement JPA interface

  // JPQL
  @Modifying // 通常與更新（update）或刪除（delete）操作一起使用 // 該方法會對資料庫中的數據進行修改，而不僅僅是讀取數據
  //必須使用void, 用@Query注解, 可以使用JPQL或原生SQL語句, 參數可以通過@Param注解進行命名參數綁定
  @Query("UPDATE User u SET u.email = :newEmail WHERE u.id = :userId")
  void updateUserEmail(@Param("userId") Long id, @Param("newEmail") String email);
  

}
