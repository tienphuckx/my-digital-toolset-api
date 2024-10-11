package com.tienphuckx.toolset.service.impl;

import com.tienphuckx.toolset.entity.user.User;
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
    public User getUserByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<User> getAllUserEntityDesc() {
        return userRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Page<User> find_by_username_pageable(String user_name, Pageable p) {
        return userRepository.findByUserNameLikeJPQL(user_name, p);
    }

    @Override
    public Page<User> find_all(Pageable p) {
        return userRepository.findAll(p);
    }

    public Page<User> searchUsers(String name, String email, String phone, Pageable pageable) {
        return userRepository.searchUsers(name, email, phone, pageable);
    }

    @Override
    public User insert_user(User user) {
        return userRepository.save(user);
    }
}
