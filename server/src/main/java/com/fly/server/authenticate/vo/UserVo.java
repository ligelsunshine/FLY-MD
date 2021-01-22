<<<<<<< HEAD:common/src/main/java/com/fly/common/model/vo/authenticate/UserVo.java
package com.fly.common.model.vo.authenticate;
=======
package com.fly.server.authenticate.vo;
>>>>>>> main:server/src/main/java/com/fly/server/authenticate/vo/UserVo.java

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * description: UserVo
 * date: 2021/1/11 22:16
 * author: LIBEL
 * version: 1.0
 */
@Data
@Accessors(chain = true)
public class UserVo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 登录认证token
     */
    private String token;
    /**
     * 当前用户的权限资源id集合
     */
    private Set<Long> resourceIds;
}
