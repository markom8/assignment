package com.htec.championship.match;

import com.htec.championship.team.TeamDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MatchFacade {

    MatchDTO getMatchById(Long matchId);

    MatchDTO saveMatch(MatchDTO matchDTO);

    Set<MatchDTO> getAll();
}
