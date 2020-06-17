package com.hooli.work.controller;

import com.hooli.work.common.ResponseResult;
import com.hooli.work.entity.User;
import com.hooli.work.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @PackgeName: com.hooli.work.controller
 * @ClassName: HelloController
 * @Author: redhood
 * Date: 2020/6/9 16:08
 * project name: school_job
 * @Version:
 * @Description:
 */

//todo:delete
@RestController
@RequestMapping("/logins")
public class TestLoginController {
    @Resource
    UserMapper userMapper;

    @PostMapping("/aaaa")
    public Integer hello() {
        return 1232;
    }

    @PostMapping("/qq")
    @ResponseBody
    public ResponseResult jump_login() {
        //这个接口放行，能不能用这个接口登录
        return ResponseResult.success("login success");
    }

    @GetMapping("/create_a_user")
    public Integer create_a_user() {
        //这个接口放行，能不能用这个接口登录
        User user = new User();
        user.setUsername("bbb");
        user.setNickname("bbb");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        int i = userMapper.insert(user);
        return i;
    }
}
