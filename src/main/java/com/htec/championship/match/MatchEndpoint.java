package com.htec.championship.match;

import com.htec.championship.team.TeamDTO;
import com.htec.championship.team.TeamFacade;
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
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/match")
public class MatchEndpoint {

    private final MatchFacade matchFacade;

    @Autowired
    public MatchEndpoint(MatchFacade matchFacade) {
        this.matchFacade = matchFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchDTO createMatch(@RequestBody MatchDTO matchDTO){
        return matchFacade.saveMatch(matchDTO);
    }

    @GetMapping("/{matchId}")
    public MatchDTO getMatch(@PathVariable Long matchId) throws EntityNotFoundException
    {
        return matchFacade.getMatchById(matchId);
    }

    @GetMapping()
    public Set<MatchDTO> getAll(){
        return matchFacade.getAll();
    }
}
