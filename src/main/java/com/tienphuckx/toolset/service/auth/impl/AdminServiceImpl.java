//package com.tienphuckx.toolset.service.auth.impl;
//
//import com.tienphuckx.toolset.entity.user.User;
//import com.tienphuckx.toolset.repository.UserRepository;
//import com.tienphuckx.toolset.service.UserService;
//import com.tienphuckx.toolset.service.auth.AdminService;
//import jakarta.persistence.Access;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AdminServiceImpl implements AdminService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public User findUserByEmail(String email) {
//        return userRepository.findByUserEmail(email);
//    }
//
//    @Override
//    public User findUserByUsername(String username) {
//        return userRepository.findByUserName(username);
//    }
//
//    @Override
//    public boolean authenticate(String username, String password) {
//        User user = userRepository.findByUserName(username);
//        if (user != null) {
//            return passwordEncoder.matches(password, user.getUserPassword());
//        }
//        return false;
//    }
//
//    @Override
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }
//}
