package com.htec.championship.group;

import com.htec.championship.match.MatchDTO;

import java.io.Serializable;
import java.util.Set;

public class GroupRecord implements Serializable {

    private static final long serialVersionUID = 713574522254752239L;

    private String groupName;

    private Set<MatchDTO> matchDTOS;

    public GroupRecord() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<MatchDTO> getMatchDTOS() {
        return matchDTOS;
    }

    public void setMatchDTOS(Set<MatchDTO> matchDTOS) {
        this.matchDTOS = matchDTOS;
    }
}
