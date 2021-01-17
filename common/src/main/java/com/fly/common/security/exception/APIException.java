package com.fly.common.security.exception;

/**
 * description: APIException
 * date: 2021/1/14 21:47
 * author: LIBEL
 * version: 1.0
 */
public class APIException extends RuntimeException {

    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
