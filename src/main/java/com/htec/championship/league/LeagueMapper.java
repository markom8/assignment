package com.htec.championship.league;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.group.GroupEntity;
import com.htec.championship.group.GroupMapper;
import com.htec.championship.group.GroupMapperDecorator;
import com.htec.championship.group.GroupRecord;
import com.htec.championship.match.MatchDTO;
import com.htec.championship.match.MatchEntity;
import com.htec.championship.match.MatchMapper;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { GroupMapper.class})
@DecoratedWith(LeagueMapperDecorator.class)
public interface LeagueMapper {


    LeagueRecord mapToLeagueDTO(LeagueEntity leagueEntity);

    List<LeagueRecord> mapToLeagueDTOS (List<LeagueEntity> leagueEntityList);

    GroupDTO mapLeagueDTOToGroupDTO(LeagueDTO groupDTO);

    @Mapping(target = "leagueId", ignore = true)
    LeagueEntity mapToLeagueEntity(LeagueDTO leagueDTO);


    @Mapping(target = "awayTeam", source = "awayTeam.teamName")
    @Mapping(target = "homeTeam", source = "homeTeam.teamName")
    @Mapping(target = "groupName", source = "groupEntity.groupName")
    @Mapping(target = "leagueName", source = "groupEntity.leagueEntity.leagueName")
    LeagueDTO mapFromMatchEntityToLeagueDTO(MatchEntity matchEntity);

    List<LeagueDTO> mapFromMatchEntitiesToLeagueDTOs(List<MatchEntity> matchEntities);
}
