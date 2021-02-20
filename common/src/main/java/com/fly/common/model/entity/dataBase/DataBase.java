package com.fly.common.model.entity.dataBase;

import com.fly.common.enums.dataBase.DataBaseType;
import lombok.Data;

/**
 * description: DataBase
 * date: 2021/1/20 21:42
 * version: 1.0
 * @author LIGEL
 */
@Data
public class DataBase {
    /**
     * description: 数据库类型
     * version: 1.0
     * date: 2021/1/20 21:43
     * author: LIBEL
     * @return
     */
    private DataBaseType type;
    /**
     * description: 版本号
     * version: 1.0
     * date: 2021/1/20 22:17
     * author: LIBEL
     * @param null
     * @return
     */
    private double version;
    /**
     * description: 数据库标书
     * version: 1.0
     * date: 2021/1/20 22:17
     * author: LIBEL
     * @return
     */
    private String description;

}
