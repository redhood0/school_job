package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
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

    @PostMapping("/getUserMsgById")
    public User getUserMsgById(@RequestBody HashMap<String,String> params) {
        User user = userService.getUserMsg(Long.parseLong(params.get("userId")));
        return user;
    }

    @PostMapping("/updateUserMsg")
    public ResponseResult updateUserMsg(@RequestBody User params) {
        userService.updateUser(params);
        return ResponseResult.success("更新个人信息成功");
    }

}
