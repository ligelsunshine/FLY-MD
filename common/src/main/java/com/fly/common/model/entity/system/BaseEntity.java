package com.fly.common.model.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * description: BaseEntity
 * date: 2021/1/12 15:39
 * version: 1.0
 * @author LIGEL
 */
@Data
public class BaseEntity {
    /**
     * description: 主键 
     * version: 1.0 
     * date: 2021/1/20 22:27 
     * author: LIBEL 
     * @param null
     * @return 
     */ 
    @TableId(type = IdType.AUTO)
    private Long id;

}
