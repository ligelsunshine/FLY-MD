
package com.fly.server.learndemo.aopdemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * description: LoggingAspect
 * date: 2021/2/20 13:49
 * version: 1.0
 * @author: LIGEL
 */

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    /**
     * description: 前置增强
     * version: 1.0
     * date: 2021/2/20 15:11
     * author: LIBEL
     * execution([权限修饰符] [返回值类型] [简单类名/全类名] [方法名]([参数列表]))
     * @return void
     */
    // @Before("@annotation(com.fly.server.learndemo.aopdemo.AopAnnotation)")
    public void beforeMethod(JoinPoint joinPoint) throws NoSuchFieldException {
    }

    /**
     * description: 通过环绕增强，在需要加入审核的方法中增加审核流程
     * version: 1.0
     * date: 2021/2/22 14:16
     * author: LIBEL
     * @param proceedingJoinPoint
     * @return java.lang.Object
     */
    // @Around("@annotation(com.fly.server.learndemo.aopdemo.AopAnnotation)")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){

        return null;
    }
}

