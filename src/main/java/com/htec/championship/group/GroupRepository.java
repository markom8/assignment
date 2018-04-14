package com.htec.championship.group;

import com.htec.championship.match.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface GroupRepository extends JpaRepository<GroupEntity, Long>, QuerydslPredicateExecutor<GroupEntity> {

    Optional<GroupEntity> findByGroupName(String groupName);

    @Query("SELECT gr.groupId FROM GroupEntity gr WHERE (gr.groupName = :groupName OR :groupName IS NULL) ")
    Long findGroupIdByGroupName(@Param("groupName") String groupName);
}
