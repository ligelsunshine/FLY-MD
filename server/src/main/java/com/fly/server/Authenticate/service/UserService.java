package com.fly.server.Authenticate.service;


import com.fly.common.model.entity.UserEntity;
import com.fly.common.model.param.LoginParam;
import com.fly.common.model.param.UserParam;
import com.fly.common.model.vo.UserVo;

/**
 * description: UserService
 * date: 2021/1/11 22:14
 * author: LIBEL
 * version: 1.0
 */

public interface UserService {
    /**
     * description: 用户登录
     * version: 1.0
     * date: 2021/1/11 22:38
     * author: LIBEL
     *
     * @param param
     * @return com.adp.FTXSecurity.model.vo.UserVo
     */
    UserVo login(LoginParam param);

    /**
     * description: 更新用户信息
     * version: 1.0
     * date: 2021/1/11 22:40
     * author: LIBEL
     *
     * @param param
     * @return void
     */
    void update(UserParam param);

    /**
     * description: 新增用户信息
     * version: 1.0
     * date: 2021/1/11 22:40
     * author: LIBEL
     *
     * @param param
     * @return void
     */
    void createUser(UserEntity param);
}
