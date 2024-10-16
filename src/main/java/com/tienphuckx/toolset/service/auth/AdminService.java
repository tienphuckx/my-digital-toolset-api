package com.tienphuckx.toolset.service.auth;

import com.tienphuckx.toolset.entity.user.User;

import java.util.List;

public interface AdminService {
    public User findUserByEmail(String email);
    public User findUserByUsername(String username);
    public boolean authenticate(String username, String password);
    public User saveUser(User user);
    public List<User> findAllUsers();
}
