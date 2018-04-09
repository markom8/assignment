package com.htec.championship.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class TeamFacadeImpl implements TeamFacade{

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamFacadeImpl(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @Override
    public Optional<TeamDTO> getTeamById(Long teamId) {
        return teamService.findTeamById(teamId).map(teamMapper::mapToTeamDTO);
    }

    @Override
    public TeamDTO saveTeam(TeamDTO teamDTO) {
        return teamMapper.mapToTeamDTO(teamService.saveTeam(teamMapper.mapToTeamEntity(teamDTO)));
    }
}
