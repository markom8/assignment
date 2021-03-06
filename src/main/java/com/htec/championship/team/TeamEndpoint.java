package com.htec.championship.team;

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
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/team")
public class TeamEndpoint {

    private final TeamFacade teamFacade;

    @Autowired
    public TeamEndpoint(TeamFacade teamFacade) {
        this.teamFacade = teamFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createTeam(@Valid @RequestBody TeamDTO teamDTO) throws ConstraintViolationException{
        return teamFacade.saveTeam(teamDTO);
    }

    @GetMapping("/{teamName}")
    public TeamDTO getTeam(@PathVariable String teamName) throws EntityNotFoundException
    {
        return teamFacade.getTeamByName(teamName);
    }

    @GetMapping
    public List<TeamEntity> getTeams() throws EntityNotFoundException{
        return  teamFacade.getAllTeams();
    }
}
