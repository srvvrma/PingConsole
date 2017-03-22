package com.pingconsole.test.rest.domain;

import java.util.List;

import com.pingconsole.environment.domain.Environment;


public class RestAPITest {
	
	private Long id;
	private String method;
	private String restAPIUrl;
	private Authorization authorization;
	private List<Header> headers;
	private List<Body> body;
	private String formDataType;
	private List<Environment> environments;
	
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
	public List<Header> getHeaders() {
		return headers;
	}
	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}
	public List<Body> getBody() {
		return body;
	}
	public void setBody(List<Body> body) {
		this.body = body;
	}
	public Long getId() {
		return id;
	}
	public List<Environment> getEnvironments() {
		return environments;
	}
	public void setEnvironments(List<Environment> environments) {
		this.environments = environments;
	}
	public String getFormDataType() {
		return formDataType;
	}
	public void setFormDataType(String formDataType) {
		this.formDataType = formDataType;
	}
	
}
