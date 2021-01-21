package com.fly.server.dataBase.controller;


import com.fly.common.model.vo.ResultVo;
import com.fly.server.dataBase.entity.DataBaseMd;
import com.fly.server.dataBase.infrastion.DataBaseMapStruct;
import com.fly.server.dataBase.param.DataBaseMdParam;
import com.fly.server.dataBase.service.DataBaseMdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fly
 * @since 2021-01-21
 */
@Api(tags = "数据库管理")
@RestController
@RequestMapping("/dataBase/data-base-md")
public class DataBaseMdController {
    @Resource
    private DataBaseMdService dataBaseMdService;
    @ApiOperation(value = "插入数据库")
    @PostMapping("/save")
    public ResultVo<String> save(@RequestBody DataBaseMdParam dataBaseParam){
        //DataBaseMd dataBase= DataBaseMapStruct.INSTANCE.DataBaseMdParamToDataBaseMd(dataBaseParam);
        DataBaseMd dataBase= new DataBaseMd();
        dataBase.setDescription(dataBaseParam.getDescription());
        dataBase.setType(dataBaseParam.getType());
        dataBase.setVersion(dataBaseParam.getVersion());
        dataBaseMdService.save(dataBase);
        return new ResultVo<>("增加成功");
    }
}
