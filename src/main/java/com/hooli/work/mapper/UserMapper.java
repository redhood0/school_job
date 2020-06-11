package com.hooli.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hooli.work.entity.User;
import com.hooli.work.entity.dto.UserDto;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cky
 * @since 2020-06-09
 */
public interface UserMapper extends BaseMapper<User> {

    UserDto selectUserByUserId(Long userId);
}
