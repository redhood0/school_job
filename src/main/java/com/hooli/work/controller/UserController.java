package com.hooli.work.controller;


import com.hooli.work.entity.User;
import com.hooli.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/getUserMsg")
    public User getUser(@RequestBody HashMap<String,String> params) {
        User user = userService.getUserMsg(params.get("username"));
        return user;
    }

}
