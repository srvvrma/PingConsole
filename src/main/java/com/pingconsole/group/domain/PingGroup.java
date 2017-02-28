package com.pingconsole.group.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pingconsole.auth.model.User;
import com.pingconsole.environment.domain.Environment;

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

	@Column
	@ManyToMany(mappedBy = "groups")
	private List<User> users;

	@Column
	@ManyToMany(mappedBy = "groupList")
	private List<Environment> environments;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(List<Environment> environments) {
		this.environments = environments;
	}

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

	public PingGroupVO getVO() {
		PingGroupVO groupVO = new PingGroupVO();
		groupVO.setId(this.getId());
		groupVO.setCode(this.getCode());
		groupVO.setName(this.getName());
		return groupVO;
	}

}
