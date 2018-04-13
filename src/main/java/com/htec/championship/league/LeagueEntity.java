package com.htec.championship.league;

import com.htec.championship.group.GroupEntity;
import com.htec.championship.match.MatchEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "championship_league")
public class LeagueEntity {

    @Id
    @Column(name = "league_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long leagueId;

    @Column(name = "league_name")
    private String leagueName;

    @OneToMany(mappedBy = "leagueEntity")
    private Set<GroupEntity> groupEntitySet = new HashSet<>();

    public LeagueEntity() {
    }

    public LeagueEntity(String leagueName, Set<GroupEntity> groupEntitySet) {
        this.leagueName = leagueName;
        this.groupEntitySet = groupEntitySet;
    }

    public LeagueEntity(String leagueName) {
        this.leagueName = leagueName;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Set<GroupEntity> getGroupEntitySet() {
        return groupEntitySet;
    }

    public void setGroupEntitySet(Set<GroupEntity> groupEntitySet) {
        this.groupEntitySet = groupEntitySet;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("leagueId", leagueId).append("leagueName", leagueName)
                                        .append("groupEntitySet", groupEntitySet).toString();
    }
}
