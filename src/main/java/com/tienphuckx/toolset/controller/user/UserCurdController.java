package com.tienphuckx.toolset.controller.user;

import com.tienphuckx.toolset.entity.user.User;
import com.tienphuckx.toolset.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserCurdController {
    private final UserService userService;

    public UserCurdController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User insert(@RequestBody User user) {
        return userService.insert_user(user);
    }
}
