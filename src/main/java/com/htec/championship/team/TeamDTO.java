package com.htec.championship.team;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO implements Serializable{

    private static final long serialVersionUID = -223066271174197750L;

    @NotNull(message = "Team name must be entered!")
    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public TeamDTO() {
    }

    public TeamDTO(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("teamName", teamName).toString();
    }
}
