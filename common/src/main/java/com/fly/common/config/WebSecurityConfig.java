package com.fly.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * description: Security配置类
 * date: 2021/1/9 11:12
 * version: 1.0
 * @author LIGEL
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * description: 配置接口连接，配置不需要认证接口，如登录接口，获取验证码接口等。
     * version: 1.0
     * date: 2021/1/11 15:47
     * author: LIBEL
     *
     * @param http
     * @return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/login").anonymous();
        http.antMatcher("/register").anonymous();
        http.antMatcher("/hello").anonymous();
        super.configure(http);
    }

    /**
     * description: 加密方法
     * version: 1.0
     * date: 2021/1/11 22:42
     * author: LIBEL
     *
     * @param
     * @return org.springframework.security.crypto.password.PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 这里我们使用bcrypt加密算法，安全性比较高
        return new BCryptPasswordEncoder();
    }

}

