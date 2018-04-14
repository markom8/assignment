package com.htec.championship.league;

import com.htec.championship.group.GroupEntity;
import com.htec.championship.group.GroupRepository;
import com.htec.championship.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LeagueServiceImpl implements LeagueService {

    private LeagueRepository leagueRepository;

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public Optional<LeagueEntity> findLeagueById(Long leagueId) {
        return leagueRepository.findById(leagueId);
    }

    @Override
    public Optional<String> findLeagueNameByLeagueid(Long leagueId) {
        return leagueRepository.findLeagueNameByLeagueid(leagueId);
    }

    @Override
    public Optional<LeagueEntity> findLeagueByLeagueName(String leagueName) {
        return leagueRepository.findByLeagueName(leagueName);
    }

    @Override
    public LeagueEntity createLeague(String leagueName) {
        return saveLeague(new LeagueEntity(leagueName));
    }

    @Override
    public LeagueEntity saveLeague(LeagueEntity leagueEntity) {
        return leagueRepository.save(leagueEntity);
    }

    @Override
    public void deleteLeague(LeagueEntity leagueEntity) {
        leagueRepository.delete(leagueEntity);
    }

    @Override
    public List<LeagueEntity> getAll() {
        return leagueRepository.findAll();
    }

}
