package com.fly.server.dataBase.infrastructure;

import com.fly.server.dataBase.entity.DataBaseMd;
import com.fly.server.dataBase.param.DataBaseMdParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DataBaseMapStructMapper {
    DataBaseMapStructMapper INSTANCE= Mappers.getMapper(DataBaseMapStructMapper.class);

    @Mapping(target = "type",source = "type")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "description", source = "description")
    DataBaseMd DataBaseMdParamToDataBaseMd(DataBaseMdParam dataBaseMdParam);
}
