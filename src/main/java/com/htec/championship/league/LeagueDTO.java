package com.htec.championship.league;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeagueDTO implements Serializable{

    private static final long serialVersionUID = -223066271174197750L;

    @NotNull(message = "error.league.groupName.null")
    @JsonProperty("leagueTitle")
    private String leagueName;

    @NotNull(message = "error.league.groupName.null")
    @JsonProperty("group")
    private String groupName;

    @NotNull(message = "error.league.matchDay.null")
    @JsonProperty("matchday")
    private int matchDay;

    @NotNull(message = "error.league.homeTeam.null")
    private String homeTeam;

    @NotNull(message = "error.league.awayTeam.null")
    private String awayTeam;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull(message = "error.group.kickoffAt.null")
    private Date kickoffAt;

    @NotNull(message = "error.group.score.null")
    private String score;

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("leagueName", leagueName).append("groupName", groupName)
                                        .append("matchDay", matchDay).append("homeTeam", homeTeam)
                                        .append("awayTeam", awayTeam).append("kickoffAt", kickoffAt)
                                        .append("score", score).toString();
    }
}
