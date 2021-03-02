package com.fly.server.learndemo.javaknowlege;

import lombok.Data;

/**
 * description: BaseObject
 * date: 2021/3/1 15:47
 * version: 1.0
 *
 * @author: LIGEL
 */
@Data
public class BaseObject  {
    private Integer id;
    private String userName;
    private String passWord;
    /**
     * description:  记录对象初始化次数
     * version: 1.0
     * date: 2021/3/1 15:54
     * @author: LIGEL
     * @param null
     */
    public static int count;

    {
        id= 12;
        userName= "admin";
        passWord = "123456789";
        count++;
    }

    public BaseObject(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public BaseObject() {
    }
}
