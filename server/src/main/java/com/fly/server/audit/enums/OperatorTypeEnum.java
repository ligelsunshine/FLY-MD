package com.fly.server.audit.enums;

import lombok.Getter;

/**
 * description: OperatorTypeEnum
 * date: 2021/2/24 9:54
 * version: 1.0
 *
 * @author: LIGEL
 */
@Getter
public enum OperatorTypeEnum {
    ADD("增加操作",0),
    UPDATE("更新操作", 1),
    DELETE("删除操作",2),
    QUERY("查询", 3);

    private String description;
    private int code;

    OperatorTypeEnum(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public static int getCodeByEnum(OperatorTypeEnum operatorTypeEnum){
        OperatorTypeEnum typeEnum = null;
        for (OperatorTypeEnum o: OperatorTypeEnum.values()) {
            if (operatorTypeEnum.getDescription().equals(o.getDescription())) {
               typeEnum= o;
            }
        }
        return typeEnum.getCode();
    }

}
