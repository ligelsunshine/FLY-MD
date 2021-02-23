package com.fly.server.audit.enums;

import lombok.Getter;

/**
 * description: DataStatusEnum
 * date: 2021/2/23 13:34
 * version: 1.0
 *
 * @author: LIGEL
 */
@Getter
public enum DataStatusEnum {
    WAIT_AUDIT("待审核", 0),
    AUDITING("审核中", 1),
    PASS_AUDIT("审核通过",2),
    REJECTED_AUDIT("审核不通过", 3);
    private String name;
    private int code;

    DataStatusEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

}
