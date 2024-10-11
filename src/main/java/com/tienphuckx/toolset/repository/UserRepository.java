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
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
    Page<UserEntity> findAll(Pageable pageable);

    // JPQL query using LIKE to search by username
    @Query("SELECT u FROM UserEntity u WHERE u.userName LIKE %:userName%")
    Page<UserEntity> findByUserNameLikeJPQL(@Param("userName") String userName, Pageable pageable);

    // Native SQL query using LIKE to search by username
    @Query(value = "SELECT * FROM tbl_user u WHERE u.user_name LIKE %:userName%", nativeQuery = true)
    Page<UserEntity> findByUserNameLikeNative(@Param("userName") String userName, Pageable pageable);

    // JPQL query to search for users based on optional parameters
    @Query("SELECT u FROM UserEntity u WHERE " +
            "(:userName IS NULL OR u.userName LIKE %:userName%) AND " +
            "(:userEmail IS NULL OR u.userEmail LIKE %:userEmail%) AND " +
            "(:userPhone IS NULL OR u.userPhone LIKE %:userPhone%)")
    Page<UserEntity> searchUsers(@Param("userName") String userName,
                                 @Param("userEmail") String userEmail,
                                 @Param("userPhone") String userPhone,
                                 Pageable pageable);
}
