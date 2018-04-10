package com.htec.championship.group;

import com.htec.championship.league.LeagueEntity;
import com.htec.championship.match.MatchEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class GroupEntity {

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "groupEntity")
    private Set<MatchEntity> matchEntitySet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "league_id", referencedColumnName = "league_id", nullable = false, insertable = false, updatable = false)
    private LeagueEntity leagueEntity;

    public GroupEntity(String groupName, Set<MatchEntity> matchEntitySet) {
        this.groupName = groupName;
        this.matchEntitySet = matchEntitySet;
    }

    public GroupEntity() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<MatchEntity> getMatchEntitySet() {
        return matchEntitySet;
    }

    public void setMatchEntitySet(Set<MatchEntity> matchEntitySet) {
        this.matchEntitySet = matchEntitySet;
    }

    public LeagueEntity getLeagueEntity() {
        return leagueEntity;
    }

    public void setLeagueEntity(LeagueEntity leagueEntity) {
        this.leagueEntity = leagueEntity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("groupId", groupId).append("groupName", groupName)
                                        .append("matchEntitySet", matchEntitySet).append("leagueEntity", leagueEntity)
                                        .toString();
    }
}
