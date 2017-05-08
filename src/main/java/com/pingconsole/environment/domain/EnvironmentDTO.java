package com.pingconsole.environment.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pingconsole.environmentUser.domain.EnvironmentUser;
import com.pingconsole.environmentUser.domain.EnvironmentUserDTO;
import com.pingconsole.group.domain.PingGroup;

public class EnvironmentDTO {

	public static final String INT = "INTEGRATION";
	public static final String CAS = "CAS";
	public static final String LMS = "LMS";
	@JsonProperty("key")
	private Long id;
	private String keyId;
	@JsonProperty("environmentType")
	private String environmentType;
	@JsonProperty("envName")
	private String envName;
	@JsonProperty("envUrl")
	private String envUrl;
	@JsonProperty("revisionNumber")
	private String revisionNumber;
	@JsonProperty("envLogUrl")
	private String envLogUrl;
	@JsonProperty("envLogUser")
	private String envLogUser;
	@JsonProperty("envLogPass")
	private String envLogPass;
	@JsonProperty("envLog")
	private String envLog;
	@JsonProperty("envWar")
	private String envWar;
	@JsonProperty("envServerLog")
	private String envServerLog;
	@JsonProperty("dbUrl")
	private String dbUrl;
	@JsonProperty("dbUser")
	private String dbUser;
	@JsonProperty("dbPass")
	private String dbPass;
	@JsonProperty("dbSchema")
	private String dbSchema;
	@JsonProperty("syncUrl")
	private String syncUrl;
	private String pingUrl;
	private List<Long> groupId;
	private List<Long> intergrationEnvironmentDTOs;
	private List<EnvironmentDTO> integrationEnvironments;
	@JsonProperty("loginDetails")
	private List<EnvironmentUserDTO> environmentUserDTOs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}

	public String getEnvName() {
		return envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getEnvUrl() {
		return envUrl;
	}

	public void setEnvUrl(String envUrl) {
		this.envUrl = envUrl;
	}

	public String getRevisionNumber() {
		return revisionNumber;
	}

	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	public String getEnvLogUrl() {
		return envLogUrl;
	}

	public void setEnvLogUrl(String envLogUrl) {
		this.envLogUrl = envLogUrl;
	}

	public String getEnvLogUser() {
		return envLogUser;
	}

	public void setEnvLogUser(String envLogUser) {
		this.envLogUser = envLogUser;
	}

	public String getEnvLogPass() {
		return envLogPass;
	}

	public void setEnvLogPass(String envLogPass) {
		this.envLogPass = envLogPass;
	}

	public String getEnvLog() {
		return envLog;
	}

	public void setEnvLog(String envLog) {
		this.envLog = envLog;
	}

	public String getEnvWar() {
		return envWar;
	}

	public void setEnvWar(String envWar) {
		this.envWar = envWar;
	}

	public String getEnvServerLog() {
		return envServerLog;
	}

	public void setEnvServerLog(String envServerLog) {
		this.envServerLog = envServerLog;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPass() {
		return dbPass;
	}

	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	public String getDbSchema() {
		return dbSchema;
	}

	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}

	public String getSyncUrl() {
		return syncUrl;
	}

	public void setSyncUrl(String syncUrl) {
		this.syncUrl = syncUrl;
	}

	public static EnvironmentDTO parse(Environment environement) {
		EnvironmentDTO environmentDTO = new EnvironmentDTO();
		environmentDTO.setId(environement.getId());
		environmentDTO.setKeyId(environement.getKeyId());
		environmentDTO.setEnvironmentType(environement.getEnvironmentType());
		environmentDTO.setEnvName(environement.getEnvName());
		environmentDTO.setEnvUrl(environement.getEnvUrl());
		environmentDTO.setRevisionNumber(environement.getRevisionNumber());
		environmentDTO.setEnvLogUrl(environement.getEnvLogUrl());
		environmentDTO.setEnvLog(environement.getEnvLog());
		environmentDTO.setEnvLogUser(environement.getEnvLogUser());
		environmentDTO.setEnvLogPass(environement.getEnvLogPass());
		environmentDTO.setEnvWar(environement.getEnvWar());
		environmentDTO.setEnvServerLog(environement.getEnvServerLog());
		environmentDTO.setDbUrl(environement.getDbUrl());
		environmentDTO.setDbUser(environement.getDbUser());
		environmentDTO.setDbPass(environement.getDbPass());
		environmentDTO.setDbSchema(environement.getDbSchema());
		environmentDTO.setPingUrl(environement.getPingUrl());
		environmentDTO.setSyncUrl(environement.getSyncUrl());
		List<Long> list = new ArrayList<>();
		List<EnvironmentUserDTO> environmentUserDTOs = new ArrayList<>();
		List<Long> integrationEnvironmentDTOs = new ArrayList<>();
		List<EnvironmentDTO> integrationEnvironments = new ArrayList<>();
		for (PingGroup group : environement.getGroupList()) {
			list.add(group.getId());
		}
		if(!CollectionUtils.isEmpty(environement.getEnvironmentUsers())){
			for (EnvironmentUser environmentUser : environement.getEnvironmentUsers()) {
				environmentUserDTOs.add(environmentUser.getDTO());
			}
		}
		if (environement.getIntergrationEnvironments() != null
				&& environement.getIntergrationEnvironments().size() > 0) {
			for (Environment intEnvironment : environement.getIntergrationEnvironments()) {
				integrationEnvironmentDTOs.add(intEnvironment.getId());
				integrationEnvironments.add(EnvironmentDTO.parse(intEnvironment));
			}
			environmentDTO.setIntegrationEnvironments(integrationEnvironments);
			environmentDTO.setIntergrationEnvironmentDTOs(integrationEnvironmentDTOs);
		}
		environmentDTO.setGroupId(list);
		environmentDTO.setEnvironmentUserDTOs(environmentUserDTOs);
		return environmentDTO;
	}

	public static Environment parse(EnvironmentDTO environmentDTO) {
		Environment environment = new Environment();
		environment.setId(environmentDTO.getId());
		environment.setKeyId(environmentDTO.getKeyId());
		// environment.setGroupList(null);
		environment.setEnvironmentType(environmentDTO.getEnvironmentType());
		environment.setEnvName(environmentDTO.getEnvName());
		environment.setEnvUrl(environmentDTO.getEnvUrl());
		environment.setRevisionNumber(environmentDTO.getRevisionNumber());
		environment.setEnvLogUrl(environmentDTO.getEnvLogUrl());
		environment.setEnvLog(environmentDTO.getEnvLog());
		environment.setEnvLogUser(environmentDTO.getEnvLogUser());
		environment.setEnvLogPass(environmentDTO.getEnvLogPass());
		environment.setEnvWar(environmentDTO.getEnvWar());
		environment.setEnvServerLog(environmentDTO.getEnvServerLog());
		environment.setDbUrl(environmentDTO.getDbUrl());
		environment.setDbUser(environmentDTO.getDbUser());
		environment.setDbPass(environmentDTO.getDbPass());
		environment.setDbSchema(environmentDTO.getDbSchema());
		environment.setPingUrl(environmentDTO.getPingUrl());
		return environment;
	}

	public List<Long> getGroupId() {
		return groupId;
	}

	public void setGroupId(List<Long> groupId) {
		this.groupId = groupId;
	}

	public String getPingUrl() {
		return pingUrl;
	}

	public void setPingUrl(String pingUrl) {
		this.pingUrl = pingUrl;
	}

	public List<Long> getIntergrationEnvironmentDTOs() {
		return intergrationEnvironmentDTOs;
	}

	public void setIntergrationEnvironmentDTOs(List<Long> intergrationEnvironmentDTOs) {
		this.intergrationEnvironmentDTOs = intergrationEnvironmentDTOs;
	}

	public List<EnvironmentDTO> getIntegrationEnvironments() {
		return integrationEnvironments;
	}

	public void setIntegrationEnvironments(List<EnvironmentDTO> integrationEnvironments) {
		this.integrationEnvironments = integrationEnvironments;
	}

	public List<EnvironmentUserDTO> getEnvironmentUserDTOs() {
		return environmentUserDTOs;
	}

	public void setEnvironmentUserDTOs(List<EnvironmentUserDTO> environmentUserDTOs) {
		this.environmentUserDTOs = environmentUserDTOs;
	}

}
