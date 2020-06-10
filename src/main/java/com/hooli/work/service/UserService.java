package com.hooli.work.service;

import com.hooli.work.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.entity.dto.UserDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yy
 * @since 2020-06-09
 */
public interface UserService extends IService<User> {
    UserDto selectUserByUserId(Long userId);
}
