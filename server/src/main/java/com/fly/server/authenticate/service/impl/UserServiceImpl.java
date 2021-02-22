package com.fly.server.authenticate.service.impl;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.fly.common.model.param.authenticate.LoginParam;
import com.fly.common.model.param.authenticate.UserParam;
import com.fly.common.model.vo.authenticate.UserVo;
import com.fly.common.security.JwtManager;
import com.fly.server.audit.astruction.AuditTagAnnotation;
import com.fly.server.authenticate.entity.UserEntity;
import com.fly.server.authenticate.mapper.UserMapper;
import com.fly.server.authenticate.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description: UserServiceImpl
 * date: 2021/1/11 22:13
 * @author: LIBEL
 * version: 1.0
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    PasswordEncoder passwordEncoder;
    @Resource
    private JwtManager jwtManager;

    @Override
    /**
     * description: 登录
     * version: 1.0
     * date: 2021/1/12 16:04
     * author: LIBEL
     * @param param
     * @return com.adp.FTXSecurity.model.vo.UserVo
     */
    public UserVo login(LoginParam param) {

        UserEntity user = userMapper.selectUserByName(param.getUserName());
        if (user == null || !passwordEncoder.matches(param.getPassWord(), user.getPassWord())) {
            throw new ApiException("账号密码错误");
        }
        UserVo userVo = new UserVo();
        userVo.setId(user.getId())
                .setUsername(user.getUserName())
                .setToken(jwtManager.generate(user.getUserName()));
        return userVo;
    }

    /**
     * description: 更新用户
     * version: 1.0
     * date: 2021/1/12 22:27
     * author: LIBEL
     *
     * @param param
     * @return void
     */
    @Override
    public void update(UserParam param) {
    }

    @Override
    @AuditTagAnnotation(tableName = "user")
    public void createUser(UserEntity param) {
        userMapper.insert(param);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
