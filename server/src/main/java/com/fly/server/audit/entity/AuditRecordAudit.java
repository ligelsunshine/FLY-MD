package com.fly.server.audit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("audit_record_audit")
public class AuditRecordAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 增加时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    /**
     * 审核标识
     */
    @TableField("audit_tag")
    private Long auditTag;

    /**
     * 所属表名
     */
    @TableField("table_name")
    private String tableName;

    /**
     * 数据编号
     */
    @TableField("data_index")
    private Long dataIndex;

    /**
     * 指定用户审核开关
     */
    @TableField("is_audit_user")
    private Integer isAuditUser;

    /**
     * 指定审核角色（多个）
     */
    @TableField("appoint_audit_rolls")
    private String appointAuditRolls;

    /**
     * 指定审核用户  (多个)
     */
    @TableField("appoint_audit_user")
    private String appointAuditUser;

    /**
     * 审核申请理由
     */
    @TableField("reason_for_applicat")
    private String reasonForApplicat;


}
