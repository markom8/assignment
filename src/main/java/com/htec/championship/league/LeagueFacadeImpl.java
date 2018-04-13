package com.htec.championship.league;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.group.GroupFacade;
import com.htec.championship.group.GroupMapper;
import com.htec.championship.group.GroupRecord;
import com.htec.championship.group.GroupService;
import com.htec.championship.match.MatchService;
import com.htec.championship.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class LeagueFacadeImpl implements LeagueFacade{

    private final LeagueService leagueService;
    private final LeagueMapper leagueMapper;
    private final TableService tableService;
    private final MatchService matchService;

    @Autowired
    public LeagueFacadeImpl(LeagueService leagueService, LeagueMapper leagueMapper, TableService tableService, MatchService matchService) {
        this.leagueService = leagueService;
        this.leagueMapper = leagueMapper;
        this.tableService = tableService;
        this.matchService = matchService;
    }

    @Override
    public LeagueRecord getLeagueById(Long leagueId) {
        return leagueMapper.mapToLeagueDTO(leagueService.findLeagueById(leagueId).get());
    }

    @Override
    public LeagueRecord saveLeague(LeagueDTO leagueDTO) {
        //tableService.syncTable(leagueDTO);
        LeagueEntity leagueEntity = leagueService.saveLeague(leagueMapper.mapToLeagueEntity(leagueDTO));
        //tableService.inputToTable(leagueDTO);
        return leagueMapper.mapToLeagueDTO(leagueEntity);
    }

    @Override
    public List<LeagueRecord> getAll() {
        return leagueMapper.mapToLeagueDTOS(leagueService.getAll());
    }

    @Override
    public List<LeagueDTO> searchLeague(LeagueSearchDTO leagueSearchDTO) {
        return leagueMapper.mapFromMatchEntitiesToLeagueDTOs(matchService.searchLeague(leagueSearchDTO.getGroupName(), leagueSearchDTO.getTeamName(), leagueSearchDTO.getDateFrom(), leagueSearchDTO.getDateTo()));
    }
}
