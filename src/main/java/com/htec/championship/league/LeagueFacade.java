package com.htec.championship.league;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.group.GroupRecord;

import java.util.List;

public interface LeagueFacade {

    LeagueRecord getLeagueById(Long leagueId);

    LeagueRecord saveLeague(LeagueDTO leagueDTO);

    List<LeagueRecord> getAll();

    List<LeagueDTO> searchLeague(LeagueSearchDTO leagueSearchDTO);
}
