package com.htec.championship.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "championship_team")
public class TeamEntity {

    @Id
    @Column(name="team_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long teamId;

    @Column(name="team_name", nullable = false, unique = true)
    private String teamName;

    public TeamEntity(String teamName) {
        this.teamName = teamName;
    }

    public TeamEntity() {
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("teamId", teamId)
                                                                         .append("teamName", teamName).toString();
    }
}
