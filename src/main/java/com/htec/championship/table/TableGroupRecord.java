package com.htec.championship.table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.htec.championship.match.MatchDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class TableGroupRecord implements Serializable {

    private static final long serialVersionUID = -7843783309679202735L;

    @JsonProperty("group")
    private String groupName;

    private Integer matchday;

    private List<TableDTO> standing;

    public TableGroupRecord() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public List<TableDTO> getStanding() {
        return standing;
    }

    public void setStanding(List<TableDTO> standing) {
        this.standing = standing;
    }
}
