package com.htec.championship.group;

import com.htec.championship.league.LeagueEntity;
import com.htec.championship.match.MatchEntity;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Optional<GroupEntity> findGroupById(Long groupId);

    Optional<GroupEntity> findGroupByName(String groupName);

    GroupEntity saveGroup(GroupEntity groupEntity);

    GroupEntity createGroup(String groupName);

    void deleteGroup(GroupEntity groupEntity);

    List<GroupEntity> findAll();
}
