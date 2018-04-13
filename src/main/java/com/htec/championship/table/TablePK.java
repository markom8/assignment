package com.htec.championship.table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TablePK implements Serializable{

    private static final long serialVersionUID = 2699172527076645975L;

    @Column(name="league_id", nullable = false)
    private Long leagueId;

    @Column(name="group_id", nullable = false)
    private Long groupId;

    @Column(name="team_id", nullable = false)
    private Long teamId;

    public TablePK() {
    }

    public TablePK(Long leagueId, Long groupId, Long teamId) {
        this.leagueId = leagueId;
        this.groupId = groupId;
        this.teamId = teamId;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        TablePK rhs = (TablePK) obj;
        return new EqualsBuilder().append(this.leagueId, rhs.leagueId).append(this.groupId, rhs.groupId)
                                  .append(this.teamId, rhs.teamId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(leagueId).append(groupId).append(teamId).toHashCode();
    }
}
