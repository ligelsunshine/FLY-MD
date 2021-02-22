package com.fly.server.audit.astruction;

import java.lang.annotation.*;

/**
 * description: 审核切面标识
 * date: 2021/2/22 19:45
 * version: 1.0
 *
 * @author: LIGEL
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditTagAnnotation {
    // 操作的表名称
    String tableName();
}
