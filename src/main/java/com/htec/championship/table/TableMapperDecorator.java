package com.htec.championship.table;

import com.htec.championship.group.GroupService;
import com.htec.championship.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class TableMapperDecorator implements TableMapper{

    @Autowired
    private TableMapper delegate;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private GroupService groupService;

    @Override
    public TableDTO mapToTableDTO(TableEntity tableEntity) {
        TableDTO tableDTO = delegate.mapToTableDTO(tableEntity);
        tableDTO.setTeam(teamRepository.findById(tableEntity.getTablePK().getTeamId()).get().getTeamName());
        return tableDTO;
    }

    @Override
    public List<TableDTO> mapToTableDTOList(List<TableEntity> tableEntities) {
        List<TableDTO> tableDTOS = new ArrayList<>();
        for(TableEntity tableEntity:tableEntities){
            tableDTOS.add(mapToTableDTO(tableEntity));
        }
        return tableDTOS;
    }

    @Override
    public List<TableGroupRecord> mapToTableGroupRecord(List<TableEntity> tableEntityList) {
        List<TableGroupRecord> tableGroupRecords = new ArrayList<>();
        Map<Long, List<TableEntity>> tableGroupRecordsGrouped =
                tableEntityList.stream().collect(Collectors.groupingBy(w -> w.getTablePK().getGroupId()));
        tableGroupRecordsGrouped.forEach((groupId, tableList)->{
            TableGroupRecord tableGroupRecord = new TableGroupRecord();
            tableGroupRecord.setGroupName(groupService.findGroupById(groupId).get().getGroupName());

            Comparator<TableDTO> comparator = Comparator.comparing(tableDTO -> tableDTO.getPoints());
            comparator = comparator.thenComparing(Comparator.comparing(tableDTO -> tableDTO.getGoals())).thenComparing(Comparator.comparing(tableDTO -> tableDTO.getGoalDifference())).reversed();
            List<TableDTO> records = mapToTableDTOList(tableList).stream().sorted(comparator).collect(Collectors.toList());
            for(int i=0; i<records.size();i++){
                records.get(i).setRank(i+1);
            }
            tableGroupRecord.setStanding(records);
            TableEntity maxTable = Collections.max(tableList, Comparator.comparing(TableEntity::getPlayedGames));
            tableGroupRecord.setMatchday(maxTable.getPlayedGames());
            tableGroupRecords.add(tableGroupRecord);
        });

        return tableGroupRecords;
    }

}
