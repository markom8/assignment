package com.htec.championship.team;

import java.util.Optional;

public interface TeamFacade {

    Optional<TeamDTO> getTeamById(Long teamId);

    TeamDTO saveTeam(TeamDTO teamDTO);
}
