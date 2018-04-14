package com.htec.championship.result;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.league.LeagueFacade;
import com.htec.championship.league.LeagueRecord;
import com.htec.championship.league.LeagueService;
import com.htec.championship.table.TableEntity;
import com.htec.championship.table.TableMapper;
import com.htec.championship.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.validation.Valid;

@Component
@Transactional
public class ResultsFacadeImpl implements ResultsFacade{

    @Autowired
    private LeagueFacade leagueFacade;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TableService tableService;

    @Autowired
    private TableMapper tableMapper;

    @Override
    public List<LeagueRecord> saveResult(List<LeagueDTO> leagueDTOS) {
        leagueDTOS.forEach(leagueDTO -> {
            leagueFacade.saveLeague(leagueDTO);
        });
        return leagueFacade.getAll();
    }

    @Override
    public List<TableEntity> saveResultReturnTable(@Valid List<LeagueDTO> leagueDTOS) {
        leagueDTOS.forEach(leagueDTO -> {
            leagueFacade.saveLeague(leagueDTO);
        });

        return tableService.getAllRanked();
    }

    @Override
    public ResultRecord saveResultReturnGroupedTable(@Valid List<LeagueDTO> leagueDTOS) {
        leagueDTOS.forEach(leagueDTO -> {
            leagueFacade.saveLeague(leagueDTO);
        });
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.setTableGroupRecords(tableMapper.mapToTableGroupRecord(tableService.getAllRanked()));
        resultRecord.setLeagueName(leagueDTOS.get(0).getLeagueName());
        return resultRecord;
    }

    @Override
    public ResultRecord saveResultReturnGroupedTableSelectedGroup(@Valid List<LeagueDTO> leagueDTOS, Long grouopId) {
        leagueDTOS.forEach(leagueDTO -> {
            leagueFacade.saveLeague(leagueDTO);
        });
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.setTableGroupRecords(tableMapper.mapToTableGroupRecord(tableService.getAllForGroup(grouopId)));
        resultRecord.setLeagueName(leagueDTOS.get(0).getLeagueName());
        return resultRecord;
    }

    @Override
    public ResultRecord returnGroupedTable() {
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.setTableGroupRecords(tableMapper.mapToTableGroupRecord(tableService.getAllRanked()));
        resultRecord.setLeagueName(leagueService.getAll().stream().findAny().get().getLeagueName());
        return resultRecord;
    }

    @Override
    public ResultRecord returnGroupedTableSelectedGroup(String groupName) {
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.setTableGroupRecords(tableMapper.mapToTableGroupRecord(tableService.getAllForGroupName(groupName)));
        resultRecord.setLeagueName(leagueService.getAll().stream().findAny().get().getLeagueName());
        return resultRecord;
    }
}
