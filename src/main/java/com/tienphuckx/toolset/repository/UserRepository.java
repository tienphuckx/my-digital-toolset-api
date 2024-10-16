package com.tienphuckx.toolset.repository;

import com.tienphuckx.toolset.entity.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findByUserName(String userName);
    User findByUserEmail(String userEmail);
    List<User> findAllByOrderByIdDesc();

    User findByUserEmailAndUserPassword(String email, String password);
    User findByUserNameAndUserPassword(String username, String password);
    User findUserEntityByUserEmailEquals(String userEmail);

    /* Raw JPQL */
    @Query("SELECT u FROM User u WHERE u.id = (SELECT MAX(p.id) FROM User p)")
    User find_max_user_id();

    @Query("SELECT u FROM User u WHERE u.userEmail = ?1")
    User select_user_by_email(String email);

    @Query("SELECT u FROM User u WHERE u.userPhone = :phone")
    List<User> select_user_by_phone(@Param("phone") String phone);

    /* UPDATE + DELETE */
    @Modifying
    @Query("UPDATE User u SET u.userPhone = :phone")
    @Transactional
    int update_user_phone(@Param("phone") String phone);

    /* NATIVE QUERY */
    @Query(value = "COUNT(id) FROM tbl_user", nativeQuery = true)
    long get_total_user();


    /* Pagedable */
    Page<User> findByUserName(String userName, Pageable pageable);
    Page<User> findAll(Pageable pageable);

    // JPQL query using LIKE to search by username
    @Query("SELECT u FROM User u WHERE u.userName LIKE %:userName%")
    Page<User> findByUserNameLikeJPQL(@Param("userName") String userName, Pageable pageable);

    // Native SQL query using LIKE to search by username
    @Query(value = "SELECT * FROM tbl_user u WHERE u.user_name LIKE %:userName%", nativeQuery = true)
    Page<User> findByUserNameLikeNative(@Param("userName") String userName, Pageable pageable);

    // JPQL query to search for users based on optional parameters
    @Query("SELECT u FROM User u WHERE " +
            "(:userName IS NULL OR u.userName LIKE %:userName%) AND " +
            "(:userEmail IS NULL OR u.userEmail LIKE %:userEmail%) AND " +
            "(:userPhone IS NULL OR u.userPhone LIKE %:userPhone%)")
    Page<User> searchUsers(@Param("userName") String userName,
                           @Param("userEmail") String userEmail,
                           @Param("userPhone") String userPhone,
                           Pageable pageable);
}
