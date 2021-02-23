package com.fly.server.learndemo.aopdemo;

import java.lang.annotation.*;

/**
 * description: AopAnnotation
 * date: 2021/2/21 19:24
 * version: 1.0
 * @author LIGEL
 */
/**
 * description:  定义该注解能出现在哪里
 *  type: 类，接口，枚举，声弱
 *  FIELD: 字段
 *  METHOD: 方法上
 * version: 1.0
 * date: 2021/2/21 19:27
 * @author LIGEL
 */
@Target(ElementType.METHOD)
/**
 * Retention的作用是定义被它所注解的注解保留多久
 * SOURCE
 * 被编译器忽略。
 * CLASS
 * 注解将会被保留在Class文件中，但在运行时并不会被VM保留。
 * 这是默认行为，所有没有用Retention注解的注解，都会采用这种策略。
 * RUNTIME
 * 保留至运行时。所以我们可以通过反射去获取注解信息。
 * @author LIGEL
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopAnnotation {
    String name();
    String value();
}
