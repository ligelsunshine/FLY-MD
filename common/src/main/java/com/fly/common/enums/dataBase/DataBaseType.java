package com.fly.common.enums.dataBase;

import lombok.Getter;

/**
 * description: 数据库类型 编号1***开头是关系型数据库，编号2***开头是非关系型数据库
 * version: 1.0
 * date: 2021/1/20 21:44
 * @author LIGEL
 * @return
 */
@Getter
public enum DataBaseType {
    /**
     有个问题，假如要更新版本哈呢？这里也不能
     */
    MySQL(1001,"mysql"),
    PostgreSQL(1002, "PostgreSQL"),
    Oracle(1003, "Oracle"),
    IBMDb2 (1005,"IBMDb2"),
    SQLServer(1006,"SQL Server"),
    MongoDB (2001, "MongoDB"),
    Redis(2001,"Redis");
    /**
     * description: 编码
     * version: 1.0
     * date: 2021/1/20 22:00
     * author: LIBEL
     * @return
     */
    private int code;
    /**
     * description: 名称
     * version: 1.0
     * date: 2021/1/20 22:00
     * author: LIBEL
     * @return
     */
    private String name;
    DataBaseType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
