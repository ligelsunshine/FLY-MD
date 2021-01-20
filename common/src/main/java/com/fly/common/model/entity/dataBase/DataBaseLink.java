package com.fly.common.model.entity.dataBase;

import com.fly.common.model.entity.system.BaseEntity;
import lombok.Data;

/**
 * description: 数据库连接记录表
 * date: 2021/1/20 22:18
 * author: LIBEL
 * version: 1.0
 */
@Data
public class DataBaseLink extends BaseEntity {
    /**
     * description: 连接名称
     * version: 1.0
     * date: 2021/1/20 22:23
     * author: LIBEL
     * @param null
     * @return
     */
    private String linkName;
    /**
     * description: 主机号
     * version: 1.0
     * date: 2021/1/20 22:24
     * author: LIBEL
     * @return
     */
    private String host;
    /**
     * description: 端口
     * version: 1.0
     * date: 2021/1/20 22:24
     * author: LIBEL
     * @return
     */
    private int port;
    /**
     * description: 用户名
     * version: 1.0
     * date: 2021/1/20 22:24
     * author: LIBEL
     * @return
     */
    private String userName;
    /**
     * description: 密码
     * version: 1.0
     * date: 2021/1/20 22:24
     * author: LIBEL
     * @return
     */
    private String passWord;

}
