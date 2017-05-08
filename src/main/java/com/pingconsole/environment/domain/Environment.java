package com.pingconsole.environment.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pingconsole.environmentUser.domain.EnvironmentUser;
import com.pingconsole.group.domain.PingGroup;

@Entity
@Table(name = "ENVIRONMENT")
public class Environment {

	@Id
	@Column(name = "environment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String keyId;

	@ManyToMany
	@JoinTable(name = "environment_group", joinColumns = @JoinColumn(name = "environment_id", referencedColumnName = "environment_id"), inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"))
	private List<PingGroup> groupList;

	@Column
	private String environmentType;
	@Column
	private String envName;
	@Column
	private String envUrl;
	@Column
	private String revisionNumber;
	@Column
	private String pingUrl;
	@Column
	private String envLogUrl;
	@Column
	private String envLogUser;
	@Column
	private String envLogPass;
	@Column
	private String envLog;
	@Column
	private String envWar;
	@Column
	private String envServerLog;
	@Column
	private String dbUrl;
	@Column
	private String dbUser;
	@Column
	private String dbPass;
	@Column
	private String dbSchema;
	@Column
	private String syncUrl;
	
	@Column
    @ManyToMany(mappedBy = "environments")
    private List<EnvironmentUser> environmentUsers;

	public List<EnvironmentUser> getEnvironmentUsers() {
		return environmentUsers;
	}

	public void setEnvironmentUsers(List<EnvironmentUser> environmentUsers) {
		this.environmentUsers = environmentUsers;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="ENVIRONMENT_FK")
	private List<Environment> intergrationEnvironments;

	public List<Environment> getIntergrationEnvironments() {
		return intergrationEnvironments;
	}

	public void setIntergrationEnvironments(List<Environment> intergrationEnvironments) {
		this.intergrationEnvironments = intergrationEnvironments;
	}

	public String getSyncUrl() {
		return syncUrl;
	}

	public void setSyncUrl(String syncUrl) {
		this.syncUrl = syncUrl;
	}

	public Environment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Environment(String keyId, String envName, String envUrl, String envLogUrl, String envLogUser,
			String envLogPass, String envLog, String envWar, String envServerLog, String dbUrl, String dbUser,
			String dbPass) {
		super();
		this.keyId = keyId;
		this.envName = envName;
		this.envUrl = envUrl;
		this.envLogUrl = envLogUrl;
		this.envLogUser = envLogUser;
		this.envLogPass = envLogPass;
		this.envLog = envLog;
		this.envWar = envWar;
		this.envServerLog = envServerLog;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
	}

	public Long getId() {
		return id;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
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

	public String getRevisionNumber() {
		return revisionNumber;
	}

	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	public String getDbSchema() {
		return dbSchema;
	}

	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}

	public String getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}

	public List<PingGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<PingGroup> groupList) {
		this.groupList = groupList;
	}

	public String getPingUrl() {
		return pingUrl;
	}

	public void setPingUrl(String pingUrl) {
		this.pingUrl = pingUrl;
	}

	@Override
	public String toString() {
		return "EnvironmentDTO [id=" + id + ", keyId=" + keyId + ", environmentType=" + environmentType + ", envName="
				+ envName + ", envUrl=" + envUrl + ", revisionNumber=" + revisionNumber + ", envLogUrl=" + envLogUrl
				+ ", envLogUser=" + envLogUser + ", envLogPass=" + envLogPass + ", envLog=" + envLog + ", envWar="
				+ envWar + ", envServerLog=" + envServerLog + ", dbUrl=" + dbUrl + ", dbUser=" + dbUser + ", dbPass="
				+ dbPass + ", dbSchema=" + dbSchema + ", syncUrl=" + syncUrl + "]";
	}
}
