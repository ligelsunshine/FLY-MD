package com.fly.server.learndemo.iocdemo;

import lombok.Data;

/**
 * description: MyTestBean
 * date: 2021/2/19 15:36
 * author: LIBEL
 * version: 1.0
 * @author LIGEL
 */
@Data
public class MyTestBean {
    private String testStr= "testStr";
    public String helloBean(String name){
        System.out.println("hello "+name);
        return "this is you first bean";
    }
}
