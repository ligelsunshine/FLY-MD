package com.fly.server.authenticate.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fly
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("user_name")
    private String userName;

    @TableField("pass_word")
    private String passWord;

    /**
     * 审核标识（用户批量审核）
     */
    @TableField("audit_tag")
    private Long auditTag;

    /**
     * 数据状态（待审核=0，审核中=1，审核通过=2，审核不通过=3，逻辑删除=4，逻辑不删除=5，）
     */
    @TableField("data_status")
    private Integer dataStatus;


}
