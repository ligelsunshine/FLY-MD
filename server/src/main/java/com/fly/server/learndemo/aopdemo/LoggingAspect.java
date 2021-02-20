/*
package com.fly.server.learndemo.aopdemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

*/
/**
 * description: LoggingAspect
 * date: 2021/2/20 13:49
 * version: 1.0
 * @author: LIGEL
 *//*

@Component
@Aspect
public class LoggingAspect {
    */
/**
     * description: 前置增强
     * version: 1.0
     * date: 2021/2/20 15:11
     * author: LIBEL
     * execution([权限修饰符] [返回值类型] [简单类名/全类名] [方法名]([参数列表]))
     * @return void
     *//*

    @Before("execution(public UserVo com.fly.server.authenticate.controller.login(..))")
    public void beforeMethod(JoinPoint joinPoint){
        Object[] args= joinPoint.getArgs();
        System.out.println("切点属性-方法名称："+joinPoint.getSignature().getName());
        System.out.println("函数参数："+args);
        System.out.println("界面开始方法");
    }
}
*/
