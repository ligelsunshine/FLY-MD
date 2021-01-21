package com.fly.server.dataBase.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author fly
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("data_base_md")
public class DataBaseMd implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 数据库类型
     */
    @TableField("type")
    private String type;

    /**
     * 版本
     */
    @TableField("version")
    private Double version;

    /**
     * 数据库描述
     */
    @TableField("description")
    private String description;


}
