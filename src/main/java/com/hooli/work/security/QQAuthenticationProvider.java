package com.hooli.work.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @PackgeName: com.hooli.work.security
 * @ClassName: QQAuthenticationProvider
 * @Author: redhood
 * Date: 2020/6/12 9:54
 * project name: school_job
 * @Version:
 * @Description:
 */
public class QQAuthenticationProvider extends DaoAuthenticationProvider {
   //todo:这里实现验证逻辑
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String code = req.getParameter("code");
//        String verify_code = (String) req.getSession().getAttribute("verify_code");
//        if (code == null || verify_code == null || !code.equals(verify_code)) {
//            throw new AuthenticationServiceException("验证码错误");
//        }
        super.additionalAuthenticationChecks(userDetails, authentication);
    }
}
