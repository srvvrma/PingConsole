package com.pingconsole.patchManager.domain;

public class PatchManagerDTO {
  
  private Long id;
  private Long environmentId;
  private String name;
  private String code;
  private String description;
  private String svnLocation;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getEnvironmentId() {
    return environmentId;
  }
  public void setEnvironmentId(Long environmentId) {
    this.environmentId = environmentId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getSvnLocation() {
    return svnLocation;
  }
  public void setSvnLocation(String svnLocation) {
    this.svnLocation = svnLocation;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
}
