package com.htec.championship.group;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.match.MatchDTO;

import java.util.List;

public interface GroupFacade {

    GroupRecord getGroupById(Long groupId);

    GroupRecord saveGroup(LeagueDTO leagueDTO);

    List<GroupEntity> findAll();
}
