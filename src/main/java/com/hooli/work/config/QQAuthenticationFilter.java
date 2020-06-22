package com.hooli.work.config;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hooli.work.entity.QQAccessEntity;
import com.hooli.work.entity.User;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @PackgeName: com.hooli.work.config
 * @ClassName: AbstractAuthenticationProcessingFilter
 * @Author: redhood
 * Date: 2020/6/9 18:39
 * project name: school_job
 * @Version:
 * @Description:
 */
@Slf4j

public class QQAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    @Resource
    UserMapper userMapper;

    public void setMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    protected QQAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher("/login/qq", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        UsernamePasswordAuthenticationToken authRequest;
        StringBuffer data = new StringBuffer();
        BufferedReader reader = httpServletRequest.getReader();
        String line;
        while (null != (line = reader.readLine())) {
            data.append(line);
        }
        reader.close();

        QQAccessEntity accessEntity = JSON.parseObject(data.toString(), QQAccessEntity.class);
        String openid = accessEntity.getOpenid();
        //todo：去tx校验有效
        //先去数据库中查，如果没有查到，就创一个新的。
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",openid);
        User user = userMapper.selectOne(userQueryWrapper);

        if(user == null){
            User newUser = new User();
            newUser.setUsername(openid);
            newUser.setNickname("勤奋的小明#" + openid.substring(3,6));
            newUser.setPassword("123456");
            newUser.setSaySomething("说些什么~");
            userMapper.insert(newUser);
        }
        authRequest = new UsernamePasswordAuthenticationToken(openid
                , new BCryptPasswordEncoder().encode("123456")
                , Arrays.asList(new SimpleGrantedAuthority("student")));

        return authRequest;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }

}
