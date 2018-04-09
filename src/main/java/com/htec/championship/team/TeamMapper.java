package com.htec.championship.team;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(source = "teamName", target = "teamName")
    TeamDTO mapToTeamDTO(TeamEntity teamEntity);

    @Mapping(source = "teamName", target = "teamName")
    TeamEntity mapToTeamEntity(TeamDTO teamDTO);
}
