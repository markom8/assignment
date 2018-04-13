package com.htec.championship.team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Optional<TeamEntity> findTeamById(Long teamId);

    Optional<TeamEntity> findTeamByTeamName(String teamName);

    TeamEntity saveTeam(TeamEntity teamEntity);

    TeamEntity createTeam(String teamName);

    TeamEntity updateTeam(TeamEntity teamEntity);

    void deleteTeam(TeamEntity teamEntity);

    List<TeamEntity> getAll();
}
