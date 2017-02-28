package com.pingconsole.group.domain;

import java.util.List;

import com.pingconsole.environment.domain.EnvironmentDTO;

public class PingGroupVO {
	private Long id;
	private String name;
	private String code;
	private List<EnvironmentDTO> environmentList;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<EnvironmentDTO> getEnvironmentList() {
		return environmentList;
	}

	public void setEnvironmentList(List<EnvironmentDTO> environmentList) {
		this.environmentList = environmentList;
	}

}
