package com.htec.championship.table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface TableRepository extends JpaRepository<TableEntity, TablePK>{

    @Query("SELECT t FROM TableEntity t order by t.points, t.goals, t.goalDifference desc ")
    List<TableEntity> findAllTablesRanked();

    @Query("SELECT t from TableEntity  t where t.tablePK.groupId = :groupId")
    List<TableEntity> findAllByTablePKGroupId(@Param("groupId") Long groupId);

}
