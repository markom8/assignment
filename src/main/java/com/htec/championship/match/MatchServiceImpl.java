package com.htec.championship.match;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.team.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
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
    public MatchEntity createMatch(Integer matchDay, TeamEntity homeTeam, TeamEntity awayTeam, Date kickoffAt,
                                   String score) {
        return saveMatch(new MatchEntity(matchDay, homeTeam, awayTeam, kickoffAt, score));
    }

    @Override
    public Optional<MatchEntity> findMatchByGroupAndMatchHomeTeamAndAwayTeam(Long awayTeam, Long homeTeam, Long groupId) {

        return matchRepository.findByAwayTeamIdAndHomeTeamIdAndGroupId(awayTeam, homeTeam, groupId);
    }

    @Override
    public Optional<MatchEntity> findByAwayTeamTeamNameAndHomeTeamTeamNameAndGroupEntityGroupName(String awayTeam,
                                                                                                  String homeTeam,
                                                                                                  String groupName) {
        return matchRepository.findByAwayTeamTeamNameAndHomeTeamTeamNameAndGroupEntityGroupName(awayTeam, homeTeam, groupName);
    }

    @Override
    public void updateMatch(MatchEntity matchEntity, MatchEntity oldMatchEntity) {
        oldMatchEntity.setHomeTeam(matchEntity.getHomeTeam());
        oldMatchEntity.setAwayTeam(matchEntity.getAwayTeam());
        oldMatchEntity.setKickoffAt(matchEntity.getKickoffAt());
        oldMatchEntity.setMatchDay(matchEntity.getMatchDay());
        oldMatchEntity.setScore(matchEntity.getScore());
        matchRepository.save(oldMatchEntity);
    }

    @Override
    public void deleteMatch(MatchEntity matchEntity) {
        matchRepository.delete(matchEntity);
    }

    @Override
    public List<MatchEntity> getAll() {
        return matchRepository.findAll();
    }

    @Override
    public List<MatchEntity> searchLeague(String groupName, String teamName, Date dateFrom, Date dateTo) {
        return matchRepository.searchLeague(groupName, teamName, dateFrom, dateTo);
    }
}
