package com.htec.championship.group;

import com.htec.championship.match.MatchEntity;
import com.htec.championship.team.TeamEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class GroupEntity {

   @Id
   @Column(name="group_id")
   @GeneratedValue(strategy= GenerationType.AUTO)
   private Long matchId;

   @Column(name = "group_name")
   private String groupName;

   @OneToMany(mappedBy = "matchEntity")
   private Set<MatchEntity> matchEntitySet = new HashSet<>();

   

}
