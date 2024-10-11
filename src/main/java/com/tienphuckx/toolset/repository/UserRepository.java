package com.tienphuckx.toolset.repository;

import com.tienphuckx.toolset.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.beans.Transient;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
    UserEntity findByUserEmail(String userEmail);
    List<UserEntity> findAllByOrderByIdDesc();

    UserEntity findByUserEmailAndUserPassword(String email, String password);
    UserEntity findByUserNameAndUserPassword(String username, String password);
    UserEntity findUserEntityByUserEmailEquals(String userEmail);

    /* Raw JPQL */
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity find_max_user_id();

    @Query("SELECT u FROM UserEntity u WHERE u.userEmail = ?1")
    UserEntity select_user_by_email(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.userPhone = :phone")
    List<UserEntity> select_user_by_phone(@Param("phone") String phone);

    /* UPDATE + DELETE */
    @Modifying
    @Query("UPDATE UserEntity u SET u.userPhone = :phone")
    @Transactional
    int update_user_phone(@Param("phone") String phone);

    /* NATIVE QUERY */
    @Query(value = "COUNT(id) FROM tbl_user", nativeQuery = true)
    long get_total_user();


    /* Pagedable */
    Page<UserEntity> get_users_by_username_with_page(String userName, Pageable pageable);
    Page<UserEntity> get_all_with_page(Pageable pageable);


}
