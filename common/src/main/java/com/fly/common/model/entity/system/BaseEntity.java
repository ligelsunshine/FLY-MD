package com.fly.common.model.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * description: BaseEntity
 * date: 2021/1/12 15:39
 * author: LIBEL
 * version: 1.0
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
    /**
     * description: 创建时间 
     * version: 1.0 
     * date: 2021/1/20 22:27 
     * author: LIBEL 
     * @param null
     * @return 
     */ 
    private LocalDateTime createTime;
    /**
     * description: 更新时间 
     * version: 1.0 
     * date: 2021/1/20 22:27 
     * author: LIBEL 
     * @param null
     * @return 
     */ 
    private LocalDateTime updateTime;
    /**
     * description: 创建人 
     * version: 1.0 
     * date: 2021/1/20 22:27 
     * author: LIBEL 
     * @param null
     * @return 
     */ 
    private String createBy;
    /**
     * description: 更新人
     * version: 1.0 
     * date: 2021/1/20 22:28 
     * author: LIBEL 
     * @param null
     * @return 
     */ 
    private String updateBy;
}
