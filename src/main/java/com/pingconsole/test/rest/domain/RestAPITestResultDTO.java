package com.pingconsole.test.rest.domain;

public class RestAPITestResultDTO {

  private Long id;
  private long responseTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(long responseTime) {
    this.responseTime = responseTime;
  }

}
