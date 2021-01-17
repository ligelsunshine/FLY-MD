package com.fly.common.config;


import com.fly.common.annotation.ExceptionCode;
import com.fly.common.enums.ResultCode;
import com.fly.common.model.vo.ResultVo;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;


/**
 * description: 全局异常处理
 * date: 2021/1/14 21:28
 * author: LIBEL
 * version: 1.0
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) throws NoSuchFieldException {
        // 为什么最后是零呢？---这里用List<ObjectError>集合来存储错误信息,默认显示第一个错误，其他的不现实
        String defaultMessage = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        // 查看错误字段
        Class<?> parameterType = exception.getParameter().getParameterType();
        String fileName = exception.getBindingResult().getFieldError().getField();
        Field field = parameterType.getDeclaredField(fileName);
        //获取注解
        ExceptionCode annotation = field.getAnnotation(ExceptionCode.class);
        // 有注解就返回注解的相应信息
        if (annotation != null) {
            /*return new ResultVo<>(annotation.value(), annotation.message(), defaultMessage);*/
            return new ResultVo<>(annotation, defaultMessage);
        }
        return new ResultVo<>(ResultCode.VALIDATE_FAILED, defaultMessage);
    }

}
