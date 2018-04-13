package com.htec.championship.result;

import com.htec.championship.group.GroupRecord;
import com.htec.championship.table.TableGroupRecord;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class ResultRecord implements Serializable {

    private static final long serialVersionUID = 713574522254752239L;

    private String leagueName;

    private List<TableGroupRecord> tableGroupRecords;

    public ResultRecord() {
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public List<TableGroupRecord> getTableGroupRecords() {
        return tableGroupRecords;
    }

    public void setTableGroupRecords(List<TableGroupRecord> tableGroupRecords) {
        this.tableGroupRecords = tableGroupRecords;
    }
}
