package com.htec.championship.team;

import java.util.List;
import java.util.Optional;

public interface TeamFacade {

    Optional<TeamDTO> getTeamById(Long teamId);

    TeamDTO saveTeam(TeamDTO teamDTO) ;

    TeamDTO getTeamByName(String teamName);

    List<TeamEntity> getAllTeams();
}
