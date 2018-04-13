package com.htec.championship.match;

import com.htec.championship.team.TeamDTO;
import com.htec.championship.team.TeamFacade;
import com.htec.championship.team.TeamMapper;
import com.htec.championship.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Transactional
public class MatchFacadeImpl implements MatchFacade{

    private final MatchService matchService;
    private final MatchMapper matchMapper;

    @Autowired
    public MatchFacadeImpl(MatchService matchService, MatchMapper matchMapper) {
        this.matchService = matchService;
        this.matchMapper = matchMapper;
    }

    @Override
    public MatchDTO getMatchById(Long matchId) {
        return matchMapper.mapToMatchDTO(matchService.findMatchById(matchId).get());
    }

    @Override
    public MatchDTO saveMatch(MatchDTO matchDTO) {
        return matchMapper.mapToMatchDTO(matchService.saveMatch(matchMapper.mapToMatchEntity(matchDTO)));
    }

    @Override
    public Set<MatchDTO> getAll() {
        return matchMapper.mapToMatchDTOs(new HashSet<MatchEntity>(matchService.getAll()));
    }
}
