package com.htec.championship.group;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.match.MatchDTO;
import com.htec.championship.match.MatchEntity;
import com.htec.championship.match.MatchMapper;
import com.htec.championship.match.MatchService;
import com.htec.championship.table.TableService;
import com.htec.championship.team.TeamEntity;
import com.htec.championship.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class GroupMapperDecorator implements GroupMapper{

    @Autowired
    private GroupMapper delegate;

    @Autowired
    private GroupService groupService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private TableService tableService;

    @Autowired
    private MatchMapper matchMapper;



    @Override
    public GroupEntity mapToGroupEntity(LeagueDTO leagueDTO) {
        GroupEntity groupEntity = null;
        GroupDTO groupDTO = mapLeagueDTOToGroupDTO(leagueDTO);

        Optional<GroupEntity> entity = groupService.findGroupByName(leagueDTO.getGroupName());
        if(entity.isPresent()){
            groupEntity = entity.get();
        }else{
            groupEntity = groupService.saveGroup(delegate.mapToGroupEntity(leagueDTO));
        }


        MatchDTO matchDTO = mapGroupDTOToMatchDTO(groupDTO);
        MatchEntity matchEntity = matchMapper.mapToMatchEntity(matchDTO);
        final boolean[] updated = { false };
        //Optional<MatchEntity> oldMatchEntityOptional = matchService.findByAwayTeamTeamNameAndHomeTeamTeamNameAndGroupEntityGroupName(groupDTO.getAwayTeam(), groupDTO.getHomeTeam(), groupDTO.getGroupName());
        groupEntity.getMatchEntitySet().forEach(matchEntity1 -> {
            if(matchEntity1.getHomeTeam().equals(matchEntity.getHomeTeam()) && matchEntity1.getAwayTeam().equals(matchEntity.getAwayTeam())){
                tableService.syncTable(leagueDTO);
                matchService.updateMatch(matchEntity, matchEntity1);

                updated[0] =true;
                //tableService.inputToTable(leagueDTO);
            }
        });
        if(!updated[0]){
            matchService.saveMatch(matchEntity);
            groupEntity.getMatchEntitySet().add(matchEntity);
            groupService.saveGroup(groupEntity);

        }
        tableService.inputToTable(leagueDTO);
        return groupEntity;
    }

    @Override
    public GroupRecord mapToGroupDTO(GroupEntity groupEntity) {
        GroupRecord groupRecord = delegate.mapToGroupDTO(groupEntity);
        groupRecord.setMatchDTOS(matchMapper.mapToMatchDTOs(groupEntity.getMatchEntitySet()));
        return groupRecord;
    }

    @Override
    public Set<GroupRecord> mapToGroupDTOs(Set<GroupEntity> groupEntities) {
        return groupEntities.stream().map(groupEntity -> mapToGroupDTO(groupEntity)).collect(Collectors.toSet());
    }
}
