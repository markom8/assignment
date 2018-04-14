package com.htec.championship.result;

import com.htec.championship.league.LeagueDTO;
import com.htec.championship.league.LeagueRecord;
import com.htec.championship.table.TableEntity;
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

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/results")
public class ResultsEndpoint {

    private final ResultsFacade resultsFacade;

    @Autowired
    public ResultsEndpoint(ResultsFacade resultsFacade) {
        this.resultsFacade = resultsFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<LeagueRecord> createResult(@Valid @RequestBody List<LeagueDTO> leagueDTOS) throws ConstraintViolationException{
         return resultsFacade.saveResult(leagueDTOS);
    }

    @PostMapping("/table")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TableEntity> createOrUpdateResultReturnTable(@Valid @RequestBody List<LeagueDTO> leagueDTOS) throws ConstraintViolationException{
        return resultsFacade.saveResultReturnTable(leagueDTOS);
    }

    @PostMapping("/grouped-table")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultRecord createResultReturnGroupedTable(@Valid @RequestBody List<LeagueDTO> leagueDTOS) throws ConstraintViolationException{
        return resultsFacade.saveResultReturnGroupedTable(leagueDTOS);
    }

    @GetMapping
    public ResultRecord returnGroupedTable(){
        return resultsFacade.returnGroupedTable();
    }

    @GetMapping("/group/{groupName}")
    public ResultRecord returnGroupedTable(@PathVariable("groupName") String groupName){
        return resultsFacade.returnGroupedTableSelectedGroup(groupName);
    }

    @PostMapping("/grouped-table/group/{groupId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultRecord createResultReturnGroupedTableSelectGroup(@PathVariable("groupId") Long groupId,@Valid @RequestBody List<LeagueDTO> leagueDTOS) throws ConstraintViolationException{
        return resultsFacade.saveResultReturnGroupedTableSelectedGroup(leagueDTOS, groupId);
    }
}
