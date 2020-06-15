package com.hooli.work.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CorsConfig
 * @Description 跨域配置
 * @Author xiaobinggan
 * @Date 2020/6/4 9:38 上午
 * @Version 1.0
 **/
@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //放行所有跨域的客户端domain
        config.addAllowedOrigin("*");
        //允许的请求方法列表
        String[] requestMethods = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
        List<String> allowedRequestMethods = Arrays.asList(requestMethods);
        config.setAllowedMethods(allowedRequestMethods);
        //允许的客户端请求头列表
        String[] requestHeaders = {"x-requested-with", "Content-Type", "Access-Token", "Authorization", "id"};
        List<String> allowedHeaders = Arrays.asList(requestHeaders);
        config.setAllowedHeaders(allowedHeaders);
        //允许的响应头列表
        String[] responseHeaders = {"Access-Control-Expose-Headers", "Access-Token"};
        List<String> allowedExposedHeaders = Arrays.asList(responseHeaders);
        config.setExposedHeaders(allowedExposedHeaders);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        // 这个顺序很重要,设置在最前
        bean.setOrder(0);
        return bean;
    }
}