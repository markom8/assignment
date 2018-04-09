package com.htec.championship.match;

import com.htec.championship.team.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface MatchRepository extends JpaRepository<MatchEntity, Long>, QuerydslPredicateExecutor<MatchEntity> {

}
