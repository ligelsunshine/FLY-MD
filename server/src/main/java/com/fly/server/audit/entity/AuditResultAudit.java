package com.fly.server.audit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("audit_result_audit")
public class AuditResultAudit implements Serializable {

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
     * 审核记录id(关联审核记录表-audit_record_audit)
     */
    @TableField("audit_record")
    private Long auditRecord;

    /**
     * 审核意见
     */
    @TableField("audit_suggestion")
    private String auditSuggestion;

    /**
     * 审核人（这里存的审核人id）
     */
    @TableField("audit_user")
    private Long auditUser;

    /**
     * 审核时间
     */
    @TableField("audit_time")
    private LocalDateTime auditTime;


}
