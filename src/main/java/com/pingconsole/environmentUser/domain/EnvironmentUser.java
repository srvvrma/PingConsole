package com.pingconsole.environmentUser.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pingconsole.environment.domain.Environment;

@Entity
public class EnvironmentUser {

  @Id
  @JsonProperty("key")
  @Column(name = "environment_user_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column
  private String userName;
  
  @Column
  private String password;
  
  @ManyToMany
  @JoinTable(name = "environment_user_map",
      joinColumns = @JoinColumn(name = "environment_user_id",
          referencedColumnName = "environment_user_id"),
      inverseJoinColumns = @JoinColumn(name = "environment_id",
          referencedColumnName = "environment_id"))
  private List<Environment> environments;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Environment> getEnvironments() {
    return environments;
  }

  public void setEnvironments(List<Environment> environments) {
    this.environments = environments;
  }

  public Long getId() {
    return id;
  }

public EnvironmentUserDTO getDTO() {
	EnvironmentUserDTO environmentUserDTO = new EnvironmentUserDTO();
	environmentUserDTO.setUserName(this.getUserName());
	environmentUserDTO.setPassword(this.getPassword());
	return environmentUserDTO;
}
  
  

}
