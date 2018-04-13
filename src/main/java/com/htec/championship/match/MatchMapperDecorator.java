package com.htec.championship.match;

import com.htec.championship.team.TeamEntity;
import com.htec.championship.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class MatchMapperDecorator implements MatchMapper{

    @Autowired
    private MatchMapper delegate;

    @Autowired
    private TeamService teamService;

    @Override
    public MatchEntity mapToMatchEntity(MatchDTO matchDTO) {

        MatchEntity matchEntity = delegate.mapToMatchEntity(matchDTO);

        Optional<TeamEntity> awayTeamEntity = teamService.findTeamByTeamName(matchDTO.getAwayTeam());
        Optional<TeamEntity> homeTeamEntity = teamService.findTeamByTeamName(matchDTO.getHomeTeam());

        if(!awayTeamEntity.isPresent()){
            matchEntity.setAwayTeam(teamService.createTeam(matchDTO.getAwayTeam()));
        }else{
            matchEntity.setAwayTeam(awayTeamEntity.get());
        }

        if(!homeTeamEntity.isPresent()){
            matchEntity.setHomeTeam(teamService.createTeam(matchDTO.getHomeTeam()));
        }else{
            matchEntity.setHomeTeam(homeTeamEntity.get());
        }
        return matchEntity;
    }

    @Override
    public Set<MatchDTO> mapToMatchDTOs(Set<MatchEntity> matchEntities) {
        return matchEntities.stream().map(matchEntity -> mapToMatchDTO(matchEntity)).collect(Collectors.toSet());
    }
}
