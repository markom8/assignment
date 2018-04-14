package com.htec.championship.table;

import com.htec.championship.group.GroupEntity;
import com.htec.championship.league.LeagueEntity;
import com.htec.championship.team.TeamEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "championship_table")
public class TableEntity {

   @EmbeddedId
   private TablePK tablePK;

   @Column
   private Integer rank;

   @Column
   private Integer playedGames;

   @Column
   private Integer points;

   @Column
   private Integer goals;

   @Column
   private Integer goalsAgainst;

   @Column
   private Integer goalDifference;

   @Column
   private Integer win;

   @Column
   private Integer lose;

   @Column
   private Integer draw;

   public TableEntity() {
   }

    public TableEntity(TablePK tablePK) {
        this.tablePK = tablePK;
        this.rank = 0;
        this.playedGames = 0;
        this.points = 0;
        this.goals = 0;
        this.goalsAgainst = 0;
        this.goalDifference = 0;
        this.win = 0;
        this.lose = 0;
        this.draw = 0;
    }

    public TableEntity(TablePK tablePK, Integer rank, Integer playedGames, Integer points, Integer goals,
                       Integer goalsAgainst, Integer goalDifference, Integer win, Integer lose, Integer draw) {
        this.tablePK = tablePK;
        this.rank = rank;
        this.playedGames = playedGames;
        this.points = points;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.win = win;
        this.lose = lose;
        this.draw = draw;
    }

    public TablePK getTablePK() {
        return tablePK;
    }

    public void setTablePK(TablePK tablePK) {
        this.tablePK = tablePK;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public void addWin(){
       this.win++;
    }


    public void decreaseWin(){
        this.win--;
    }

    public void removePoints(int i) {
        this.points = this.points-i;
    }

    public void decreaseLose() {
        this.lose--;
    }

    public void decreaseDraw() {
        this.draw--;
    }

    public void decreasePlayedGames() {
        this.playedGames--;
    }

    public void removeGoals(Integer goals) {
        this.goals = this.goals - goals;
    }

    public void removeGoalsAgainst(Integer goals) {
        this.goalsAgainst= this.goalsAgainst - goals;
    }

    public void removeGoalDifference(int i) {
        this.goalDifference= this.goalDifference-i;
    }

    public void increaseWin() {
        this.win++;
    }

    public void addPoints(int i) {
        this.points= this.points + i;
    }

    public void increaseLose() {
        this.lose++;
    }

    public void increaseDraw() {
        this.draw++;
    }

    public void increasePlayedGames() {
        this.playedGames++;
    }

    public void addGoals(Integer goals) {
        this.goals= this.goals + goals;
    }

    public void addGoalsAgainst(Integer goals) {
        this.goalsAgainst=this.goalsAgainst + goals;
    }

    public void addGoalDifference(int i) {
        this.goalDifference= this.goalDifference + i;
    }
}
