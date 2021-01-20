
package com.fly.server.authenticate.mapper;

import com.fly.common.model.entity.authenticate.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * description: 更具用户名称查找用户
     * version: 1.0
     * date: 2021/1/12 12:01
     * author: LIBEL
     *
     * @param userName
     * @return com.adp.FTXSecurity.model.entity.UserEntity
     */
    UserEntity selectUserByName(String userName);

    /**
     * description: 新增用户
     * version: 1.0
     * date: 2021/1/12 16:22
     * author: LIBEL
     *
     * @param userEntity
     * @return void
     */
    void insert(@Param("userEntity") UserEntity userEntity);
}