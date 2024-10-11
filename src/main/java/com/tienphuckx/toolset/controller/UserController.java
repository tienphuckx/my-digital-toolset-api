package com.tienphuckx.toolset.controller;

import com.tienphuckx.toolset.entity.user.UserEntity;
import com.tienphuckx.toolset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
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
    public List<UserEntity> getUserPage() {
        List<UserEntity> allUsers;
        allUsers = userService.getAllUserEntityDesc();
        return allUsers;
    }

    /*
        Get all with paging
        http://localhost:8080/users/get-all-paging?pageNumber=0&pageSize=10&sort=id&direction=desc
    */

    @RequestMapping(value = "/get-all-paging", method = RequestMethod.GET)
    public Page<UserEntity> getUsersWithPagination(
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

}
