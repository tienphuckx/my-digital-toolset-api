package com.tienphuckx.toolset.service;

import com.tienphuckx.toolset.entity.user.UserEntity;
import com.tienphuckx.toolset.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserEntity getUserByUsername(String username);
    UserEntity getUserByEmail(String email);
    List<UserEntity> getUsers();

    List<UserEntity> getAllUserEntityDesc();


    /*Pageable*/
    Page<UserEntity> find_by_username_pageable(String email, Pageable p);
    Page<UserEntity> find_all(Pageable p);
}
