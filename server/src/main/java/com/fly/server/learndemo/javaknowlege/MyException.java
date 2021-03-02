package com.fly.server.learndemo.javaknowlege;

import java.io.IOException;

/**
 * description: MyException
 * date: 2021/3/2 11:15
 * version: 1.0
 *
 * @author: LIGEL
 */
public class MyException extends IOException {
    private String exceptionName ;
    private int code;

    {
        exceptionName = "自定义异常类";
        code = 1001;
    }

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

}
