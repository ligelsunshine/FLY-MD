package com.fly.server.authenticate.controller;


import com.fly.common.annotation.NotResponseBody;
import com.fly.common.model.param.authenticate.LoginParam;
import com.fly.common.model.vo.system.ResultVo;
import com.fly.server.authenticate.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * description: ValidateController
 * date: 2021/1/15 22:21
 * version: 1.0
 * @author LIGEL
 */
@RestController
@Api(value = "validated", tags = "验证接口集合")
@RequestMapping("/valid")
public class ValidateController {
    @ApiOperation(value = "验证")
    @PostMapping("/validTest")
    public ResultVo<String> ValidTest(@RequestBody @Validated LoginParam param) {
        return new ResultVo<>("成功");
    }

    /**
     * description: 测试统一响应题
     * version: 1.0
     * date: 2021/1/15 21:40
     * author: LIBEL
     *
     * @param
     * @return com.adp.FTXSecurity.model.vo.ResultVo<com.adp.FTXSecurity.model.entity.UserEntity>
     */
    @ApiOperation(value = "验证2")
    @GetMapping("/getUser")
    public ResultVo<UserEntity> GetUser() {
        UserEntity user = new UserEntity();
        user.setId(242424242L);
        user.setUserName("admin");
        user.setPassWord("admin123");
        return new ResultVo<>(user);
    }

    /**
     * description: 测试全局响应
     * version: 1.0
     * date: 2021/1/15 21:40
     * author: LIBEL
     *
     * @param
     * @return com.adp.FTXSecurity.model.entity.UserEntity
     */
    @NotResponseBody
    @ApiOperation(value = "验证3")
    @GetMapping("/getUsers")
    public UserEntity getUsers() {
        UserEntity user = new UserEntity();
        user.setId(242424242L);
        user.setUserName("admin");
        user.setPassWord("admin123");
        return user;
    }
}
