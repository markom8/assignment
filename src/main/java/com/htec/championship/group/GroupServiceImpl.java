package com.htec.championship.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<GroupEntity> findGroupById(Long groupId) {
        return groupRepository.findById(groupId);
    }

    @Override
    public Optional<GroupEntity> findGroupByName(String groupName) {
        return groupRepository.findByGroupName(groupName);
    }

    @Override
    public GroupEntity saveGroup(GroupEntity groupEntity) {
        return groupRepository.save(groupEntity);
    }

    @Override
    public GroupEntity createGroup(String groupName) {
        return saveGroup(new GroupEntity(groupName));
    }

    @Override
    public void deleteGroup(GroupEntity groupEntity) {
        groupRepository.delete(groupEntity);
    }

    @Override
    public List<GroupEntity> findAll() {
        return groupRepository.findAll();
    }
}
