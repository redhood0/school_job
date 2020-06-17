package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hooli.work.entity.User;
import com.hooli.work.execption.ServiceException;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public int updateUser(User user) {


        return 0;
    }

    @Override
    public User getUserMsg(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null || user.getIsDelete() == 1){
            throw new ServiceException("用户名不存在");
        }
        return user;
    }


}
