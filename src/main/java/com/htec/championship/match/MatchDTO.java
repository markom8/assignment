package com.htec.championship.match;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchDTO implements Serializable{

    private static final long serialVersionUID = -223066271174197750L;

    @NotNull(message = "error.match.matchDay.null")
    @JsonProperty("matchday")
    private int matchDay;

    @NotNull(message = "error.match.homeTeam.null")
    private String homeTeam;

    @NotNull(message = "error.match.awayTeam.null")
    private String awayTeam;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull(message = "error.match.kickoffAt.null")
    private Date kickoffAt;

    @NotNull(message = "error.match.score.null")
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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("matchDay", matchDay).append("homeTeam", homeTeam)
                                        .append("awayTeam", awayTeam).append("kickoffAt", kickoffAt)
                                        .append("score", score).toString();
    }
}
