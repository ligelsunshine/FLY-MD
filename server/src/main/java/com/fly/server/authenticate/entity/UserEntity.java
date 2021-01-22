<<<<<<< HEAD:common/src/main/java/com/fly/common/model/entity/authenticate/UserEntity.java
package com.fly.common.model.entity.authenticate;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fly.common.model.entity.system.BaseEntity;
=======
package com.fly.server.authenticate.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fly.common.model.entity.BaseEntity;
>>>>>>> main:server/src/main/java/com/fly/server/authenticate/entity/UserEntity.java
import lombok.Data;

import java.io.Serializable;

/**
 * description: User
 * date: 2021/1/8 13:05
 * author: LIBEL
 * version: 1.0
 */
@Data
@TableName("user")
public class UserEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1116044912711071062L;
    /**
     * description: 用户名称
     * version: 1.0
     * date: 2021/1/12 16:15
     * author: LIBEL
     *
     * @param null
     * @return
     */
    private String userName;
    /**
     * description: 用户密码
     * version: 1.0
     * date: 2021/1/12 16:15
     * author: LIBEL
     *
     * @param null
     * @return
     */
    private String passWord;


}
