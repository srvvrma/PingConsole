package com.pingconsole.environmentUser.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pingconsole.environment.domain.Environment;


public class EnvironmentUserDTO {

  private Long id;
  @JsonProperty("userName")
  private String userName;
  @JsonProperty("password")
  private String password;
  private List<Long> environmentIds;

  public EnvironmentUserDTO() {
    super();
    // TODO Auto-generated constructor stub
  }

  public EnvironmentUserDTO(String userName, String password, List<Long> environmentIds) {
    super();
    this.userName = userName;
    this.password = password;
    this.environmentIds = environmentIds;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public List<Long> getEnvironmentIds() {
    return environmentIds;
  }

  public void setEnvironmentIds(List<Long> environmentIds) {
    this.environmentIds = environmentIds;
  }

  public static EnvironmentUserDTO parse(EnvironmentUser environmentUser) {
    EnvironmentUserDTO environmentUserDTO = new EnvironmentUserDTO();
    environmentUserDTO.setId(environmentUser.getId());
    environmentUserDTO.setUserName(environmentUser.getUserName());
    environmentUserDTO.setPassword(environmentUser.getPassword());
    environmentUserDTO.setEnvironmentIds(new ArrayList<>());
    if(!CollectionUtils.isEmpty(environmentUser.getEnvironments())){
      for (Environment environment : environmentUser.getEnvironments()) {
        environmentUserDTO.getEnvironmentIds().add(environment.getId());
      }
    }
    return environmentUserDTO;
  }

}
