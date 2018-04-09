package com.htec.championship.team;

import java.util.Optional;

public interface TeamService {

    Optional<TeamEntity> findTeamById(Long teamId);

    TeamEntity saveTeam(TeamEntity teamEntity);

    TeamEntity updateTeam(TeamEntity teamEntity);

    void deleteTeam(TeamEntity teamEntity);
}
