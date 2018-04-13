package com.htec.championship.match;

import static org.hibernate.loader.Loader.SELECT;

import com.htec.championship.group.GroupEntity;
import com.htec.championship.league.LeagueEntity;
import com.htec.championship.team.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {

    @Query("SELECT match FROM MatchEntity match WHERE match.awayTeam.teamId = ?1 AND match.homeTeam.teamId = ?2 and (?3 is null OR match.groupEntity.groupId = ?3)")
    Optional<MatchEntity> findByAwayTeamIdAndHomeTeamIdAndGroupId(Long awayTeam, Long homeTeam, Long groupId);

    Optional<MatchEntity> findByAwayTeamTeamNameAndHomeTeamTeamNameAndGroupEntityGroupName(String awayTeam, String homeTeam, String groupName);

    @Query(""
            + "SELECT m "
            + "FROM MatchEntity m "
            + "WHERE (m.groupEntity.groupName = :gropName OR :groupName IS NULL)"
            + "AND (m.awayTeam.teamName = :teamName OR m.homeTeam.teamName = :teamName OR :teamName IS NULL)"
            + "AND (m.kickoffAt > :dateFrom OR :dateFrom IS NULL)"
            + "AND (m.kickoffAt < :dateTo OR :dateTO IS NULL)")

    List<MatchEntity> searchLeague( @Param("groupName") String groupName, @Param("teamName") String teamName, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

}
