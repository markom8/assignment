package com.htec.championship.match;

import com.htec.championship.team.TeamEntity;

import java.util.Optional;

public interface MatchService {

    Optional<MatchEntity> findMatchById(Long matchId);

    MatchEntity saveMatch(MatchEntity matchEntity);

    void deleteMatch(MatchEntity matchEntity);
}
