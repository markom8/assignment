package com.htec.championship.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface TeamRepository extends JpaRepository<TeamEntity, Long>, QuerydslPredicateExecutor<TeamEntity> {

    Optional<TeamEntity> findByTeamName(String teamName);

    @Query("SELECT team.teamId FROM TeamEntity team WHERE team.teamName = ?1")
    Long findTeamIdByTeamName(String teamName);
}
