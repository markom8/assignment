package com.htec.championship.match;

import com.htec.championship.group.GroupEntity;
import com.htec.championship.team.TeamEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "championship_match")
public class MatchEntity {

    @Id
    @Column(name = "match_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchId;

    @Column(name = "match_day", nullable = false)
    private Integer matchDay;

    @ManyToOne
    @JoinColumn(name = "home_team", referencedColumnName = "team_id")
    private TeamEntity homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team", referencedColumnName = "team_id")
    private TeamEntity awayTeam;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private GroupEntity groupEntity;

    @Column(name = "kickoff_at", nullable = false)
    private Date kickoffAt;

    @Column(nullable = false)
    private String score;

    public MatchEntity() {
    }

    public MatchEntity(Integer matchDay, TeamEntity homeTeam, TeamEntity awayTeam, Date kickoffAt, String score) {
        this.matchDay = matchDay;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickoffAt = kickoffAt;
        this.score = score;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

    public TeamEntity getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamEntity homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamEntity getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamEntity awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Date getKickoffAt() {
        return kickoffAt;
    }

    public void setKickoffAt(Date kickoffAt) {
        this.kickoffAt = kickoffAt;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public GroupEntity getGroupEntity() {
        return groupEntity;
    }

    public void setGroupEntity(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("matchId", matchId).append("matchDay", matchDay)
                                        .append("homeTeam", homeTeam).append("awayTeam", awayTeam)
                                        .append("groupEntity", groupEntity).append("kickoffAt", kickoffAt)
                                        .append("score", score).toString();
    }

}
