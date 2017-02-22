package com.pingconsole.environment.domain;

import java.util.List;

import com.pingconsole.group.domain.PingGroup;

public class EnvironementDTO {

	private Long id;
	private String keyId;
	private List<PingGroup> groupList;
	private String environmentType;
	private String envName;
	private String envUrl;
	private String revisionNumber;
	private String envLogUrl;
	private String envLogUser;
	private String envLogPass;
	private String envLog;
	private String envWar;
	private String envServerLog;
	private String dbUrl;
	private String dbUser;
	private String dbPass;
	private String dbSchema;
	private String syncUrl;
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
	public List<PingGroup> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<PingGroup> groupList) {
		this.groupList = groupList;
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
	public static EnvironementDTO parse(Environment environement) {
		EnvironementDTO environementDTO = new EnvironementDTO();
		environementDTO.setId(environement.getId());
		environementDTO.setKeyId(environement.getKeyId());
		environementDTO.setGroupList(null);
		environementDTO.setEnvironmentType(environement.getEnvironmentType());
		environementDTO.setEnvName(environement.getEnvName());
		environementDTO.setEnvUrl(environement.getEnvUrl());
		environementDTO.setRevisionNumber(environement.getRevisionNumber());
		environementDTO.setEnvLogUrl(environement.getEnvLogUrl());
		environementDTO.setEnvLog(environement.getEnvLog());
		environementDTO.setEnvLogUser(environement.getEnvLogUser());
		environementDTO.setEnvLogPass(environement.getEnvLogPass());
		environementDTO.setEnvWar(environement.getEnvWar());
		environementDTO.setEnvServerLog(environement.getEnvServerLog());
		environementDTO.setDbUrl(environement.getDbUrl());
		environementDTO.setDbUser(environement.getDbUser());
		environementDTO.setDbPass(environement.getDbPass());
		environementDTO.setDbSchema(environement.getDbSchema());
		return environementDTO;
	}
	
	

}
