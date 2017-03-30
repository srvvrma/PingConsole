package com.pingconsole.patchRecord.domain;

import java.util.Date;
import java.util.List;

import com.pingconsole.environment.domain.EnvironmentDTO;

public class PatchRecordDTO {

	private Long id;

	private String name;

	private Long environment;

	private Date createDate;

	private List<Long> users;

	private String patchData;

	private String jiraId;

	private String description;

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

	public Long getEnvironment() {
		return environment;
	}

	public void setEnvironment(Long environment) {
		this.environment = environment;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Long> getUsers() {
		return users;
	}

	public void setUsers(List<Long> users) {
		this.users = users;
	}

	public String getPatchData() {
		return patchData;
	}

	public void setPatchData(String patchData) {
		this.patchData = patchData;
	}

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
