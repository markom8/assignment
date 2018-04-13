package com.htec.championship.group;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.match.MatchDTO;
import com.htec.championship.match.MatchFacade;
import com.htec.championship.match.MatchMapper;
import com.htec.championship.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GroupFacadeImpl implements GroupFacade{

    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @Autowired
    public GroupFacadeImpl(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @Override
    public GroupRecord getGroupById(Long groupId) {
        return groupMapper.mapToGroupDTO(groupService.findGroupById(groupId).get());
    }

    @Override
    public GroupRecord saveGroup(LeagueDTO leagueDTO) {
        return groupMapper.mapToGroupDTO(groupService.saveGroup(groupMapper.mapToGroupEntity(leagueDTO)));
    }

    @Override
    public List<GroupEntity> findAll() {
        return groupService.findAll();
    }
}
