package com.htec.championship.match;

import com.htec.championship.team.TeamEntity;
import com.htec.championship.team.TeamRepository;
import com.htec.championship.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Optional<MatchEntity> findMatchById(Long matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public MatchEntity saveMatch(MatchEntity matchEntity) {
        return matchRepository.save(matchEntity);
    }

    @Override
    public void deleteMatch(MatchEntity matchEntity) {
        matchRepository.delete(matchEntity);
    }
}
