package com.htec.championship.match;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.team.TeamEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MatchService {

    Optional<MatchEntity> findMatchById(Long matchId);

    MatchEntity saveMatch(MatchEntity matchEntity);

    MatchEntity createMatch(Integer matchDay, TeamEntity homeTeam, TeamEntity awayTeam, Date kickoffAt, String score);

    Optional<MatchEntity> findMatchByGroupAndMatchHomeTeamAndAwayTeam(Long awayTeam, Long homeTeam, Long groupId);

    Optional<MatchEntity> findByAwayTeamTeamNameAndHomeTeamTeamNameAndGroupEntityGroupName(String awayTeam, String homeTeam, String groupName);

    void deleteMatch(MatchEntity matchEntity);

    List<MatchEntity> getAll();

    void updateMatch(MatchEntity matchEntity, MatchEntity oldMatchEntity);

    List<MatchEntity> searchLeague(String gropName, String teamName, Date dateFrom, Date dateTo);
}
