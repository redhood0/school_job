package com.hooli.work.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hooli.work.entity.User;
import com.hooli.work.entity.User4Security;
import com.hooli.work.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @PackgeName: com.hooli.work.config
 * @ClassName: CustomUserService
 * @Author: redhood
 * Date: 2020/6/12 8:28
 * project name: school_job
 * @Version:
 * @Description:
 */
@Component
@Slf4j
public class CustomUserService  implements UserDetailsService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        userMapper.selectById();
//        log.info("===>loadUserByUsername=====>");
        // 从数据库尝试读取该用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",s);

        User user = userMapper.selectOne(queryWrapper);
//        log.error("=====>"+user);
        // 用户不存在，抛出异常
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        User4Security user4Security = new User4Security();
        user4Security.setPassword(user.getPassword());
        user4Security.setUsername(user.getUsername());
        user4Security.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("admin")));
        // 将数据库形式的roles解析为UserDetails的权限集
        // AuthorityUtils.commaSeparatedStringToAuthorityList()是Spring Security提供的
        // 该方法用于将逗号隔开的权限集合字符串切割成可用权限对象列表
        // 当然也可以自己实现，如用分号来隔开等，参考generateAuthorities
//        user.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("admin")));

        return user4Security;
    }
}
