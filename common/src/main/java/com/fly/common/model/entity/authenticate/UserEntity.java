package com.fly.common.model.entity.authenticate;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fly.common.model.entity.system.BaseEntity;
import lombok.Data;
import java.io.Serializable;

/**
 * description: User
 * date: 2021/1/8 13:05
 * version: 1.0
 * @author LIGEL
 */
@Data
@TableName("user")
public class UserEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1116044912711071062L;
    /**
     * description: 用户名称
     * version: 1.0
     * date: 2021/1/12 16:15
     * author: LIBEL
     * @param null
     * @return
     */
    private String userName;
    /**
     * description: 用户密码
     * version: 1.0
     * date: 2021/1/12 16:15
     * author: LIBEL
     * @param null
     * @return
     */
    private String passWord;


}
