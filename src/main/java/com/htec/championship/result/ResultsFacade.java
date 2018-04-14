package com.htec.championship.result;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.league.LeagueEntity;
import com.htec.championship.league.LeagueRecord;
import com.htec.championship.table.TableEntity;

import java.util.List;

import javax.validation.Valid;

public interface ResultsFacade {

    List<LeagueRecord> saveResult(List<LeagueDTO> leagueDTOS);

    List<TableEntity> saveResultReturnTable(@Valid List<LeagueDTO> leagueDTOS);

    ResultRecord saveResultReturnGroupedTable(@Valid List<LeagueDTO> leagueDTOS);

    ResultRecord saveResultReturnGroupedTableSelectedGroup(@Valid List<LeagueDTO> leagueDTOS, Long grouopId);

    ResultRecord returnGroupedTable();

    ResultRecord returnGroupedTableSelectedGroup(String groupName);
}
