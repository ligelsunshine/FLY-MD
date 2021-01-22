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
@TableName("data_base_link")
public class DataBaseLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 连接名称
     */
    @TableField("linkName")
    private String linkName;

    /**
     * 主机号
     */
    @TableField("host")
    private String host;

    /**
     * 端口
     */
    @TableField("port")
    private Integer port;

    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    @TableField("passWord")
    private String passWord;

    /**
     * 外键：数据库表
     */
    @TableField("dataBaseId")
    private String dataBaseId;

    /**
     * 链接状态（0=冻结，1=启用）
     */
    @TableField("state")
    private Integer state;


}
