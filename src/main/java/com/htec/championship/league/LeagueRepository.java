package com.htec.championship.league;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface LeagueRepository extends JpaRepository<LeagueEntity, Long>{

    Optional<LeagueEntity> findByLeagueName(String leagueName);

    @Query("SELECT league.leagueId FROM LeagueEntity league WHERE league.leagueName = ?1")
    Long findLeagueIdByLeagueName(String leagueName);

    @Query("SELECT league.leagueName FROM LeagueEntity league WHERE league.leagueId = ?1")
    Optional<String> findLeagueNameByLeagueid(Long leagueId);
}
