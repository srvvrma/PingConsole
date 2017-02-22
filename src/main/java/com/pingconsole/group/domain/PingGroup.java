package com.pingconsole.group.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class PingGroup {

  public static final int CODE_EXIST = 1;
  public static final int NAME_EXIST = 2;
  public static final int NO_ERROR = 0;

  @Id
  @JsonProperty("key")
  @Column(name = "group_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @Column
  private String code;

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
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



}
