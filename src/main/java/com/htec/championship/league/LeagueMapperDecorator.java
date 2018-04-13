package com.htec.championship.league;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.group.GroupEntity;
import com.htec.championship.group.GroupMapper;
import com.htec.championship.group.GroupRecord;
import com.htec.championship.group.GroupService;
import com.htec.championship.match.MatchDTO;
import com.htec.championship.match.MatchEntity;
import com.htec.championship.match.MatchMapper;
import com.htec.championship.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class LeagueMapperDecorator implements LeagueMapper {

    @Autowired
    private LeagueMapper delegate;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public LeagueRecord mapToLeagueDTO(LeagueEntity leagueEntity) {
        LeagueRecord leagueRecord = delegate.mapToLeagueDTO(leagueEntity);
        leagueRecord.setGroupRecords(groupMapper.mapToGroupDTOs(leagueEntity.getGroupEntitySet()));
        return leagueRecord;
    }

    @Override
    public List<LeagueRecord> mapToLeagueDTOS(List<LeagueEntity> leagueEntityList) {
        return leagueEntityList.stream().map(leagueEntity -> mapToLeagueDTO(leagueEntity)).collect(Collectors.toList());
    }

    @Override
    public LeagueEntity mapToLeagueEntity(LeagueDTO leagueDTO) {
        LeagueEntity leagueEntity = null;
        Optional<LeagueEntity> entity = leagueService.findLeagueByLeagueName(leagueDTO.getLeagueName());
        if (entity.isPresent()) {
            leagueEntity = entity.get();
        } else {
            leagueEntity = leagueService.saveLeague(delegate.mapToLeagueEntity(leagueDTO));
        }

        GroupEntity groupEntity = groupService.saveGroup(groupMapper.mapToGroupEntity(leagueDTO));
        groupService.saveGroup(groupEntity);
        leagueEntity.getGroupEntitySet().add(groupEntity);
        return leagueEntity;
    }

    @Override
    public List<LeagueDTO> mapFromMatchEntitiesToLeagueDTOs(List<MatchEntity> matchEntities) {
        List<LeagueDTO> leagueDTOS = new ArrayList<>();
        return matchEntities.stream().map(matchEntitie->mapFromMatchEntityToLeagueDTO(matchEntitie)).collect(Collectors.toList());
    }
}
