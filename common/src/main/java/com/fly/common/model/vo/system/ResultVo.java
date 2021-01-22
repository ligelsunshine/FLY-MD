package com.fly.common.model.vo.system;


import com.fly.common.annotation.ExceptionCode;
import com.fly.common.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: ResultVo
 * date: 2021/1/14 21:50
 * author: LIBEL
 * version: 1.0
 */
@Data
@ApiModel
public class ResultVo<T> {
    @ApiModelProperty(value = "状态码", notes = "默认1000是成功")
    private int code;
    @ApiModelProperty(value = "响应信息", notes = "来说明响应情况")
    private String msg;
    @ApiModelProperty(value = "响应的具体数据")
    private T data;

    public ResultVo(T data) {
        this(ResultCode.SUCCESS, data);
    }

    /**
     * description: 提供返回错误码和错误信息
     * version: 1.0
     * date: 2021/1/15 22:05
     * author: LIBEL
     *
     * @param resultCode
     * @param data
     * @return
     */
    public ResultVo(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public ResultVo(ExceptionCode annotation, T data) {
        this.code = annotation.value();
        this.msg = annotation.message();
        this.data = data;
    }

    public ResultVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
