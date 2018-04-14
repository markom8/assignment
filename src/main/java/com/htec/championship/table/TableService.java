package com.htec.championship.table;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.league.LeagueEntity;

import java.util.List;
import java.util.Optional;

public interface TableService {

    Optional<TableEntity> findTableById(TablePK tablePK);

    TableEntity saveTable(TableEntity tableEntity);

    void syncTable(LeagueDTO leagueDTO);

    void deleteTable(TableEntity tableEntity);

    void inputToTable(LeagueDTO leagueDTO);

    List<TableEntity> getAll();

    List<TableEntity> getAllRanked();

    List<TableEntity> getAllForGroup(Long groupId);

    List<TableEntity> getAllForGroupName(String groupName);
}
