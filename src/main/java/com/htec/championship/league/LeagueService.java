package com.htec.championship.league;

import com.htec.championship.group.GroupEntity;

import java.util.List;
import java.util.Optional;

public interface LeagueService {

    Optional<LeagueEntity> findLeagueById(Long leagueId);

    Optional<LeagueEntity> findLeagueByLeagueName(String leagueName);

    LeagueEntity createLeague(String leagueName);

    LeagueEntity saveLeague(LeagueEntity leagueEntity);

    void deleteLeague(LeagueEntity leagueEntity);

    List<LeagueEntity> getAll();

}
