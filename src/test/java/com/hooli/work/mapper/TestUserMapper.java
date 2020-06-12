package com.hooli.work.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hooli.work.entity.User;
import com.hooli.work.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @PackgeName: mapper
 * @ClassName: TestUserMapper
 * @Author: redhood
 * Date: 2020/6/12 10:26
 * project name: school_job
 * @Version:
 * @Description:
 */
@SpringBootTest
@Slf4j
public class TestUserMapper {
    @Resource
    UserMapper userMapper;
    @Test
    void testGetUser(){
        // 从数据库尝试读取该用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","bbb");

        User user = userMapper.selectOne(queryWrapper);
        log.error("=====>"+user);
    }
}
