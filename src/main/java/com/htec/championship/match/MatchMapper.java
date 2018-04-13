package com.htec.championship.match;

import com.htec.championship.team.TeamDTO;
import com.htec.championship.team.TeamEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
@DecoratedWith(MatchMapperDecorator.class)
public interface MatchMapper {


    @Mapping(source="awayTeam.teamName", target = "awayTeam")
    @Mapping(source = "homeTeam.teamName", target = "homeTeam")
    MatchDTO mapToMatchDTO(MatchEntity matchEntity);

    Set<MatchDTO> mapToMatchDTOs(Set<MatchEntity> matchEntities);

    @Mapping(target = "matchId", ignore = true)
    @Mapping(target = "homeTeam", ignore = true)
    @Mapping(target = "awayTeam", ignore = true)
    MatchEntity mapToMatchEntity(MatchDTO matchDTO);
}
