package com.htec.championship.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<TeamEntity> findTeamById(Long teamId) {
        return teamRepository.findById(teamId);
    }

    @Override
    public Optional<TeamEntity> findTeamByTeamName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }

    @Override
    public TeamEntity saveTeam(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    @Override
    public TeamEntity createTeam(String teamName) {
        return saveTeam(new TeamEntity(teamName));
    }

    @Override
    public TeamEntity updateTeam(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    @Override
    public void deleteTeam(TeamEntity teamEntity) {
        teamRepository.delete(teamEntity);
    }

    @Override
    public List<TeamEntity> getAll() {
        return teamRepository.findAll();
    }
}
