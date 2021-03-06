package com.fly.server.authenticate.controller;
import com.fly.server.authenticate.entity.UserEntity;
import com.fly.server.authenticate.param.LoginParam;
import com.fly.server.authenticate.param.RegisterParam;
import com.fly.server.authenticate.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.fly.server.authenticate.service.UserService;

import javax.annotation.Resource;

/**
 * description: LoginController
 * date: 2021/1/9 11:16
 * author: LIBEL
 * version: 1.0
 */
@Api(value = "spring-security测试", tags = "登录注册接口集合")
@RestController
@ResponseBody//如果不加这个会出现栈指针问题，这个解决方法也是在网上查找到的
@RequestMapping("/API")
public class LoginAndRegisterController {
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserService userService;

    /**
     * description: 登录
     * version: 1.0
     * date: 2021/1/12 16:33
     * author: LIBEL
     *
     * @param param
     * @return com.adp.FTXSecurity.model.vo.UserVo
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public UserVo login(@RequestBody @Validated LoginParam param, BindingResult bindingResult) {
        return userService.login(param);
    }


    /**
     * description: 注册接口
     * version: 1.0
     * date: 2021/1/11 22:03
     * author: LIBEL
     *
     * @param param
     * @return java.lang.String
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public String register(@RequestBody RegisterParam param) {
        UserEntity user = new UserEntity();
        user.setUserName(param.getUserName());
        //对密码进行加密，加密规则可以自己定义，这里用的是spring-security提供的其中一种。
        user.setPassWord(passwordEncoder.encode(param.getPassWord()));
        userService.createUser(user);
        return "注册成功！";
    }

}
