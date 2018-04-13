package com.htec.championship.group;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.match.MatchDTO;
import com.htec.championship.match.MatchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "api/group")
public class GroupEndpoint {

    private final GroupFacade groupFacade;

    @Autowired
    public GroupEndpoint(GroupFacade groupFacade) {
        this.groupFacade = groupFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupRecord createGroup(@RequestBody LeagueDTO leagueDTO){
        return groupFacade.saveGroup(leagueDTO);
    }

    @GetMapping("/{groupId}")
    public GroupRecord getGroup(@PathVariable Long groupId) throws EntityNotFoundException
    {
        return groupFacade.getGroupById(groupId);
    }

    @GetMapping()
    public List<GroupEntity> getAll(){
        return groupFacade.findAll();
    }
}
