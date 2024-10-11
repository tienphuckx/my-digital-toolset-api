package com.tienphuckx.toolset.service;

import com.tienphuckx.toolset.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getUsers();

    List<User> getAllUserEntityDesc();


    /*Pageable*/
    Page<User> find_by_username_pageable(String email, Pageable p);
    Page<User> find_all(Pageable p);

    Page<User> searchUsers(String name, String email, String phone, Pageable pageable);

    User insert_user(User user);
}
