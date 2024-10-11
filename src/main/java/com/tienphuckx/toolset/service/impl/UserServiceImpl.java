package com.tienphuckx.toolset.service.impl;

import com.tienphuckx.toolset.entity.user.UserEntity;
import com.tienphuckx.toolset.repository.UserRepository;
import com.tienphuckx.toolset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<UserEntity> getAllUserEntityDesc() {
        return userRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Page<UserEntity> find_by_username_pageable(String email, Pageable p) {
        return userRepository.findByUserName(email, p);
    }

    @Override
    public Page<UserEntity> find_all(Pageable p) {
        return userRepository.findAll(p);
    }
}
