package com.hooli.work.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @PackgeName: com.hooli.work.security
 * @ClassName: QQAuthenticationManager
 * @Author: redhood
 * Date: 2020/6/12 10:07
 * project name: school_job
 * @Version:
 * @Description:
 */
public class QQAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        authentication.setAuthenticated(true);

        return authentication;
    }
}
