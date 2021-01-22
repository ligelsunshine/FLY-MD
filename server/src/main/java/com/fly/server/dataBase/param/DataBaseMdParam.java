package com.fly.server.dataBase.param;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * description: DataBaseMdParam
 * date: 2021/1/21 22:08
 * author: LIBEL
 * version: 1.0
 */
@Data
public class DataBaseMdParam {
    /**
     * 数据库类型
     */
    private String type;

    /**
     * 版本
     */
    private Double version;

    /**
     * 数据库描述
     */
    private String description;
}
