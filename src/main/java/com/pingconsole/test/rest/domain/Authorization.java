package com.pingconsole.test.rest.domain;

public class Authorization {
	
	public static final String NO_AUTH = "NO_AUTH";
	public static final String BASIC_AUTH = "BASIC_AUTH";
	public static final String DIGEST_AUTH = "DIGEST_AUTH";
	public static final String OAUTH_1_0 = "OAUTH_1_0";
	public static final String OAUTH_2_0 = "OAUTH_2_0";
	public static final String HAWK_AUTH = "HAWK_AUTH";
	public static final String AWS_SIGN = "AWS_SIGN";
	
	
	private Long id;
	private String authType;
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	public Long getId() {
		return id;
	}
	

}
