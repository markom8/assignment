package com.htec.championship.league;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.group.GroupFacade;
import com.htec.championship.group.GroupRecord;
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
@RequestMapping(path = "api/league")
public class LeagueEndpoint {

    private final LeagueFacade leagueFacade;

    @Autowired
    public LeagueEndpoint(LeagueFacade leagueFacade) {
        this.leagueFacade = leagueFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeagueRecord addResultsAndUpdateLeague(@RequestBody LeagueDTO leagueDTO){
        return leagueFacade.saveLeague(leagueDTO);
    }

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<LeagueDTO> searchResultsOfLeague(@RequestBody LeagueSearchDTO leagueSearchDTO){
        return leagueFacade.searchLeague(leagueSearchDTO);
    }

    @GetMapping("/{leagueId}")
    public LeagueRecord getLeague(@PathVariable Long leagueId) throws EntityNotFoundException
    {
        return leagueFacade.getLeagueById(leagueId);
    }

    @GetMapping()
    public List<LeagueRecord> getAll(){
        return leagueFacade.getAll();
    }
}
