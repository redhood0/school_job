package com.hooli.work.service;

import com.hooli.work.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface UserService extends IService<User> {

    int updateUser(User user);

    User getUserMsg(String username);

    User getUserMsg(Long userId);
}
