package com.fly.server.authenticate.service;


import com.fly.common.model.param.authenticate.LoginParam;
import com.fly.common.model.param.authenticate.UserParam;
import com.fly.common.model.vo.authenticate.UserVo;
import com.fly.server.authenticate.entity.UserEntity;


/**
 * description: UserService
 * date: 2021/1/11 22:14
 * version: 1.0
 * @author LIGEL
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
