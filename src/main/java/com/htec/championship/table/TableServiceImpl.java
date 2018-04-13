package com.htec.championship.table;

import com.htec.championship.group.GroupRepository;
import com.htec.championship.league.LeagueDTO;
import com.htec.championship.league.LeagueEntity;
import com.htec.championship.league.LeagueRepository;
import com.htec.championship.league.LeagueService;
import com.htec.championship.match.MatchEntity;
import com.htec.championship.match.MatchRepository;
import com.htec.championship.team.TeamEntity;
import com.htec.championship.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TableServiceImpl implements TableService {

    private TableRepository tableRepository;
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private LeagueRepository leagueRepository;
    private GroupRepository groupRepository;

    @Autowired
    public TableServiceImpl(TableRepository tableRepository, MatchRepository matchRepository, TeamRepository teamRepository, LeagueRepository leagueRepository, GroupRepository groupRepository) {
        this.tableRepository = tableRepository;
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<TableEntity> findTableById(TablePK tablePK) {
        return tableRepository.findById(tablePK);
    }

    @Override
    public TableEntity saveTable(TableEntity tableEntity) {
        return tableRepository.save(tableEntity);
    }

    @Override
    public void syncTable(LeagueDTO leagueDTO) {
                matchRepository.findByAwayTeamTeamNameAndHomeTeamTeamNameAndGroupEntityGroupName(leagueDTO.getAwayTeam(),leagueDTO.getHomeTeam(),leagueDTO.getGroupName()).ifPresent(matchEntity -> {
                    TablePK teamAwayTablePK = new TablePK(leagueRepository.findLeagueIdByLeagueName(leagueDTO.getLeagueName()), groupRepository.findGroupIdByGroupName(leagueDTO.getGroupName()), teamRepository.findTeamIdByTeamName(leagueDTO.getAwayTeam()));
                    TablePK teamHomeTablePK = new TablePK(leagueRepository.findLeagueIdByLeagueName(leagueDTO.getLeagueName()), groupRepository.findGroupIdByGroupName(leagueDTO.getGroupName()), teamRepository.findTeamIdByTeamName(leagueDTO.getAwayTeam()));

                    TableEntity awayTableEntity = findTableById(teamAwayTablePK).get();
                    TableEntity homeTableEntity = findTableById(teamHomeTablePK).get();

                    String[] goals = leagueDTO.getScore().split(":");
                    Integer homeGoals = Integer.valueOf(goals[0]);
                    Integer awayGoals = Integer.valueOf(goals[1]);

                    //home team wins
                    if (homeGoals.compareTo(awayGoals) > 0) {
                        homeTableEntity.decreaseWin();
                        homeTableEntity.removePoints(3);
                        awayTableEntity.decreaseLose();
                    }
                    //away team wins
                    else if (homeGoals.compareTo(awayGoals) < 0) {
                        homeTableEntity.decreaseLose();
                        awayTableEntity.decreaseWin();
                        awayTableEntity.removePoints(3);
                    }
                    //draw
                    else if (homeGoals.compareTo(awayGoals) == 0) {
                        homeTableEntity.decreaseDraw();
                        homeTableEntity.removePoints(1);
                        awayTableEntity.decreaseDraw();
                        awayTableEntity.removePoints(1);
                    }

                    homeTableEntity.decreasePlayedGames();
                    homeTableEntity.removeGoals(homeGoals);
                    homeTableEntity.removeGoalsAgainst(awayGoals);
                    homeTableEntity.removeGoalDifference(homeGoals - awayGoals);

                    awayTableEntity.decreasePlayedGames();
                    awayTableEntity.removeGoals(awayGoals);
                    awayTableEntity.removeGoalsAgainst(homeGoals);
                    awayTableEntity.removeGoalDifference(awayGoals - homeGoals);

                    saveTable(homeTableEntity);
                    saveTable(awayTableEntity);
                });
    }

    @Override
    public void inputToTable(LeagueDTO leagueDTO) {
//        Optional<MatchEntity> matchEntity = matchRepository.findByAwayTeamTeamNameAndHomeTeamTeamNameAndGroupEntityGroupName(leagueDTO.getAwayTeam(),leagueDTO.getHomeTeam(),leagueDTO.getGroupName());
//        if() {
            TablePK teamAwayTablePK = new TablePK(leagueRepository.findLeagueIdByLeagueName(leagueDTO.getLeagueName()),
                                                  groupRepository.findGroupIdByGroupName(leagueDTO.getGroupName()),
                                                  teamRepository.findTeamIdByTeamName(leagueDTO.getAwayTeam()));
            TablePK teamHomeTablePK = new TablePK(leagueRepository.findLeagueIdByLeagueName(leagueDTO.getLeagueName()),
                                                  groupRepository.findGroupIdByGroupName(leagueDTO.getGroupName()),
                                                  teamRepository.findTeamIdByTeamName(leagueDTO.getHomeTeam()));

            TableEntity awayTableEntity = findTableById(teamAwayTablePK).orElse(new TableEntity(teamAwayTablePK));
            TableEntity homeTableEntity = findTableById(teamHomeTablePK).orElse(new TableEntity(teamHomeTablePK));

            String[] goals = leagueDTO.getScore().split(":");
            Integer homeGoals = Integer.valueOf(goals[0]);
            Integer awayGoals = Integer.valueOf(goals[1]);

            //home team wins
            if (homeGoals.compareTo(awayGoals) > 0) {
                homeTableEntity.increaseWin();
                homeTableEntity.addPoints(3);
                awayTableEntity.increaseLose();
            }
            //away team wins
            else if (homeGoals.compareTo(awayGoals) < 0) {
                homeTableEntity.increaseLose();
                awayTableEntity.increaseWin();
                awayTableEntity.addPoints(3);
            }
            //draw
            else if (homeGoals.compareTo(awayGoals) == 0) {
                homeTableEntity.increaseDraw();
                homeTableEntity.addPoints(1);
                awayTableEntity.increaseDraw();
                awayTableEntity.addPoints(1);
            }

            homeTableEntity.increasePlayedGames();
            homeTableEntity.addGoals(homeGoals);
            homeTableEntity.addGoalsAgainst(awayGoals);
            homeTableEntity.addGoalDifference(homeGoals - awayGoals);

            awayTableEntity.increasePlayedGames();
            awayTableEntity.addGoals(awayGoals);
            awayTableEntity.addGoalsAgainst(homeGoals);
            awayTableEntity.addGoalDifference(awayGoals - homeGoals);

            saveTable(homeTableEntity);
            saveTable(awayTableEntity);
//        }
    }

    @Override
    public void deleteTable(TableEntity tableEntity) {
        tableRepository.delete(tableEntity);
    }

    @Override
    public List<TableEntity> getAll() {
        return tableRepository.findAll();
    }

    @Override
    public List<TableEntity> getAllRanked() {
        List<TableEntity> tableEntities= tableRepository.findAllTablesRanked();
        return tableEntities;
    }

    @Override
    public List<TableEntity> getAllForGroup(Long groupId) {
        return tableRepository.findAllByTablePKGroupId(groupId);
    }
}
