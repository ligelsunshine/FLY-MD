package com.fly.server.dataBase.infrastion;

import com.fly.server.dataBase.entity.DataBaseMd;
import com.fly.server.dataBase.param.DataBaseMdParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DataBaseMapStruct {
    DataBaseMapStruct INSTANCE= Mappers.getMapper(DataBaseMapStruct.class);
    @Mapping(source = "type", target = "type")
    @Mapping(source = "version", target = "version")
    @Mapping(source = "description", target = "description")
    public DataBaseMd DataBaseMdParamToDataBaseMd(DataBaseMdParam dataBaseMdParam);
}
