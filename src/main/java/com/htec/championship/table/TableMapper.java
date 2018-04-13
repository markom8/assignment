package com.htec.championship.table;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(TableMapperDecorator.class)
public interface TableMapper {

    @Mapping(target = "team", ignore = true)
    TableDTO mapToTableDTO(TableEntity tableEntity);

    List<TableDTO> mapToTableDTOList(List<TableEntity> tableEntity);


    List<TableGroupRecord> mapToTableGroupRecord(List<TableEntity> tableEntityList);

}
