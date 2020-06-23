package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
        //todo：限制更新的字段
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", user.getId());
        int num = userMapper.update(user, userUpdateWrapper);
        if(num == 0){
            throw new ServiceException("更新个人信息失败");
        }
        return num;
    }

    @Override
    public User getUserMsg(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null || user.getIsDelete() == 1) {
            throw new ServiceException("用户名不存在");
        }
        return user;
    }

    @Override
    public User getUserMsg(Long userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null || user.getIsDelete() == 1) {
            throw new ServiceException("用户id不存在");
        }
        return user;
    }


}
