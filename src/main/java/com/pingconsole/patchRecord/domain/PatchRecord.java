package com.pingconsole.patchRecord.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.pingconsole.auth.model.User;
import com.pingconsole.environment.domain.Environment;

@Entity
public class PatchRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String name;

  @ManyToOne
  private Environment environment;

  private Date createDate;

  @Column
  @ManyToMany(mappedBy = "patchRecords")
  private List<User> users;

  @Lob
  private String patchData;

  private String jiraId;

  private String description;

  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public String getPatchData() {
    return patchData;
  }

  public void setPatchData(String patchData) {
    this.patchData = patchData;
  }

  public String getJiraId() {
    return jiraId;
  }

  public void setJiraId(String jiraId) {
    this.jiraId = jiraId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
