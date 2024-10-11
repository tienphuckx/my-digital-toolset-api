package com.tienphuckx.toolset.controller;

import com.tienphuckx.toolset.entity.user.UserEntity;
import com.tienphuckx.toolset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public List<UserEntity> getUserPage() {
        List<UserEntity> allUsers;
        allUsers = userService.getAllUserEntityDesc();
        return allUsers;
    }

    /*Get with paging*/

}
