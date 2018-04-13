package com.htec.championship.league;

import com.htec.championship.group.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface LeagueRepository extends JpaRepository<LeagueEntity, Long>, QuerydslPredicateExecutor<LeagueEntity> {

    Optional<LeagueEntity> findByLeagueName(String leagueName);

    @Query("SELECT league.leagueId FROM LeagueEntity league WHERE league.leagueName = ?1")
    Long findLeagueIdByLeagueName(String leagueName);


}
