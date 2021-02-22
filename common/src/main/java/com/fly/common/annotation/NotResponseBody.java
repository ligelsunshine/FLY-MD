package com.fly.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description:  不加入全局响应注解
 * version: 1.0
 * date: 2021/1/15 21:33
 * @author LIGEL
 * @return
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD}) /*只能放在方法上*/
public @interface NotResponseBody {
}
