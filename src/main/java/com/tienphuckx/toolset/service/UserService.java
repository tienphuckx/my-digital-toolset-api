package com.tienphuckx.toolset.service;

import com.tienphuckx.toolset.entity.user.UserEntity;
import com.tienphuckx.toolset.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserEntity getUserByUsername(String username);
    UserEntity getUserByEmail(String email);
    List<UserEntity> getUsers();

    List<UserEntity> getAllUserEntityDesc();
}
