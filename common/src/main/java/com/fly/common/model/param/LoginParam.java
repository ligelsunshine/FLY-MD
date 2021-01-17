package com.fly.common.model.param;

import com.fly.common.annotation.ExceptionCode;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * description: LoginParam
 * date: 2021/1/11 22:35
 * author: LIBEL
 * version: 1.0
 */
@Data
public class LoginParam {
    @NotBlank(message = "用户名不能为空")
    @Length(min = 4, max = 12, message = "用户名长度在4-12位")
    @ExceptionCode(value = 10001, message = "用户名错误")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 4, max = 12, message = "密码长度为4-12位")
    @ExceptionCode(value = 10002, message = "密码错误")
    private String passWord;
}
