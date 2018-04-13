package com.htec.championship.group;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.match.MatchDTO;
import com.htec.championship.match.MatchEntity;
import com.htec.championship.match.MatchMapper;
import com.htec.championship.match.MatchMapperDecorator;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = { MatchMapper.class})
@DecoratedWith(GroupMapperDecorator.class)
public interface GroupMapper {

    @Mapping(target = "groupName", source = "groupName")
    GroupRecord mapToGroupDTO(GroupEntity groupEntity);

    Set<GroupRecord> mapToGroupDTOs(Set<GroupEntity> groupEntities);

    MatchDTO mapGroupDTOToMatchDTO(GroupDTO groupDTO);

    GroupDTO mapLeagueDTOToGroupDTO(LeagueDTO groupDTO);

    @Mapping(target = "groupId", ignore = true)
    @Mapping(target = "groupName", source = "groupName")
    GroupEntity mapToGroupEntity(LeagueDTO groupDTO);
}
