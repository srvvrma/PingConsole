package com.pingconsole.roles.dto;

import java.util.List;

public class RoleDTO {

  private String name;
  private Long id;
  private String code;
  private List<String> privileges;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrivileges() {
    return privileges.toString();
  }
  
  public List<String> getPrivilegeList() {
    return privileges;
  }

  public void setPrivileges(List<String> privileges) {
    this.privileges = privileges;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
