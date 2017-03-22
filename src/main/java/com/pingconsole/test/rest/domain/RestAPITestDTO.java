package com.pingconsole.test.rest.domain;

import java.util.List;

public class RestAPITestDTO {
  private Long id;
  private String method;
  private String restAPIUrl;
  private Authorization authorization;
  private List<HeaderDTO> headers;
  private List<BodyDTO> body;
  private String formDataType;
  private List<Long> environments;
  
  public String getMethod() {
      return method;
  }
  public void setMethod(String method) {
      this.method = method;
  }
  public String getRestAPIUrl() {
      return restAPIUrl;
  }
  public void setRestAPIUrl(String restAPIUrl) {
      this.restAPIUrl = restAPIUrl;
  }
  public Authorization getAuthorization() {
      return authorization;
  }
  public void setAuthorization(Authorization authorization) {
      this.authorization = authorization;
  }
  public List<HeaderDTO> getHeaders() {
      return headers;
  }
  public void setHeaders(List<HeaderDTO> headers) {
      this.headers = headers;
  }
  public List<BodyDTO> getBody() {
      return body;
  }
  public void setBody(List<BodyDTO> body) {
      this.body = body;
  }
  public Long getId() {
      return id;
  }
  public List<Long> getEnvironments() {
      return environments;
  }
  public void setEnvironments(List<Long> environments) {
      this.environments = environments;
  }
  public String getFormDataType() {
      return formDataType;
  }
  public void setFormDataType(String formDataType) {
      this.formDataType = formDataType;
  }
  

}
