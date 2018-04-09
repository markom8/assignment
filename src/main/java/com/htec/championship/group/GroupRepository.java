package com.htec.championship.group;

import com.htec.championship.match.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface GroupRepository extends JpaRepository<GroupEntity, Long>, QuerydslPredicateExecutor<GroupEntity> {

}
