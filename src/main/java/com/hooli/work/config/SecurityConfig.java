package com.hooli.work.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hooli.work.common.ResponseResult;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.security.MacLoginUrlAuthenticationEntryPoint;
import com.hooli.work.security.QQAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @PackgeName: com.hooli.work.config
 * @ClassName: SecurityConfig
 * @Author: redhood
 * Date: 2020/6/9 16:14
 * project name: school_job
 * @Version:
 * @Description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    UserMapper userMapper;
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomUserService customUserService;// 上面定义

    @Bean
    public AuthenticationEntryPoint macLoginUrlAuthenticationEntryPoint() {
        return new MacLoginUrlAuthenticationEntryPoint("/logins/aaaa");
    }

    /**
     * @return 封装身份认证提供者
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserService);  //自定义的用户和角色数据提供者
        authenticationProvider.setPasswordEncoder(passwordEncoder()); //设置密码加密对象
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置身份认证提供者
        auth.authenticationProvider(authProvider());
    }

    /**
     * 自定义 QQ登录 过滤器
     */
    private QQAuthenticationFilter qqAuthenticationFilter() {
        QQAuthenticationFilter filter = new QQAuthenticationFilter("/login/qq");
//        authenticationFilter.setAuthenticationManager(new QQAuthenticationManager());
        filter.setMapper(userMapper);
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandlerImpl());
        return filter;
    }

    public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
            System.out.println("Successfully Authentication");
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();

            HashMap<String,Object> userinfo= new HashMap<>();
            userinfo.put("msg","登录成功");
            userinfo.put("username",authentication.getName());
            userinfo.put("nickname",authentication.getName());
            userinfo.put("role",authentication.getAuthorities());

            ResponseResult responseResult =  ResponseResult.success(userinfo);
            out.write(new ObjectMapper().writeValueAsString(responseResult));
            out.flush();
            out.close();
        }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(qqAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http
                .authorizeRequests()
//                .antMatchers("/logins/create_a_user").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .successHandler((req, resp, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(principal));
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString("请先登录"));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and().exceptionHandling()
                .authenticationEntryPoint(macLoginUrlAuthenticationEntryPoint())
                .and()
                .formLogin().and()
                .cors().disable()
                .csrf().disable();
    }
}
