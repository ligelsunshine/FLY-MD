package com.fly.common.model.param;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description: 這裡引入了验证依赖，spring-boot-starter-validation,适合用来进行简单的数据验证
 * date: 2021/1/11 22:24
 * author: LIBEL
 * version: 1.0
 */
@Data
public class UserParam {
    @NotNull(message = "用户id不能为空", groups = Update.class)
    private Long id;
    @NotBlank(message = "用戶名不能為空", groups = CreateUser.class)
    @Length(min = 4, max = 12, message = "用户名长度为4-12位", groups = CreateUser.class)
    private String userName;
    private List<Long> roleIds;
    private List<Long> companyIds;

    public interface Update {
    }

    public interface CreateUser {
    }
}
