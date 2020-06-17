package com.hooli.work.service;

import com.hooli.work.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @PackgeName: com.hooli.work.service
 * @ClassName: UserServiceTest
 * @Author: redhood
 * Date: 2020/6/15 14:42
 * project name: school_job
 * @Version:
 * @Description:
 */
@SpringBootTest
public class UserServiceTest {
    @Resource
    UserService userService;

    @Test
    public void testGetUserMsg(){
       User user =  userService.getUserMsg("bbb");
        System.out.println("==>"+user);
    }

}
