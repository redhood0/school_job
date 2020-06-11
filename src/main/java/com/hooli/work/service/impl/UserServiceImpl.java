package com.hooli.work.service.impl;

import com.hooli.work.entity.User;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
