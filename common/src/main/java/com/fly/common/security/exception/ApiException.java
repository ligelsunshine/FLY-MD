package com.fly.common.security.exception;

/**
 * description: APIException
 * date: 2021/1/14 21:47
 * version: 1.0
 * @author LIGEL
 */
public class ApiException extends RuntimeException {

    private int code;
    private String msg;

    public ApiException() {
        this(1001, "接口错误");
    }

    public ApiException(String msg) {
        this(1001, msg);
    }

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
