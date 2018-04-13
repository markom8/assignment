package com.htec.championship.league;

import com.htec.championship.group.GroupDTO;
import com.htec.championship.group.GroupRecord;
import com.htec.championship.match.MatchDTO;

import java.io.Serializable;
import java.util.Set;

public class LeagueRecord implements Serializable {

    private static final long serialVersionUID = 713574522254752239L;

    private String leagueName;

    private Set<GroupRecord> groupRecords;

    public LeagueRecord() {
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Set<GroupRecord> getGroupRecords() {
        return groupRecords;
    }

    public void setGroupRecords(Set<GroupRecord> groupRecords) {
        this.groupRecords = groupRecords;
    }
}
