package com.tienphuckx.toolset.controller.user;

import com.tienphuckx.toolset.entity.user.User;
import com.tienphuckx.toolset.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello World!";
    }

    /*Get all without paging*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserPage() {
        List<User> allUsers;
        allUsers = userService.getAllUserEntityDesc();
        return allUsers;
    }

    /*
        Get all with paging
        http://localhost:8080/users/get-all-paging?pageNumber=0&pageSize=10&sort=id&direction=desc
    */

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Page<User> getUsersWithPagination(
            @RequestParam int pageNumber,
            @RequestParam int pageSize,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ){
        Sort.Direction sortDirection = direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable p = PageRequest.of(pageNumber, pageSize, sortBy);
        return userService.find_all(p);
    }

    /*Search with params*/
    @RequestMapping(value = "search-user-name", method = RequestMethod.GET)
    public Page<User> searchUser(@RequestParam String name,
                                 @RequestParam int pageNumber,
                                 @RequestParam int pageSize,
                                 @RequestParam(defaultValue = "id") String sort,
                                 @RequestParam(defaultValue = "desc") String direction) {
        Sort.Direction sortDirection = direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable p = PageRequest.of(pageNumber, pageSize, sortBy);
        return userService.find_by_username_pageable(name, p);
    }

    @RequestMapping(value = "/search-user", method = RequestMethod.GET)
    public Page<User> searchUser(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction) {

        // Determine sort direction
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);

        // Create pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortBy);

        // Call service to search users based on optional params
        return userService.searchUsers(name, email, phone, pageable);
    }
}
