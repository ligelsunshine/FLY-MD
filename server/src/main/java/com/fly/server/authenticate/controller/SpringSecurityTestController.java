package com.fly.server.authenticate.controller;

import com.fly.common.annotation.NotResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: SpringSecurityTestController
 * date: 2021/1/7 13:32
 * author: LIBEL
 * version: 1.0
 */
@RequestMapping("/test")
@Api(value = "Hello-World", tags = "系统运行测试接口")
@RestController
public class SpringSecurityTestController {
    @NotResponseBody
    @ApiOperation("接口测试")
    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world !";
    }
}
