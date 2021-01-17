package com.fly.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * description: BaseEntity
 * date: 2021/1/12 15:39
 * author: LIBEL
 * version: 1.0
 */
@Data
public class BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
}
