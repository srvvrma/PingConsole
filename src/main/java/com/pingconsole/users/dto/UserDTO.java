package com.pingconsole.users.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pingconsole.auth.model.Role;
import com.pingconsole.auth.model.User;
import com.pingconsole.group.domain.PingGroup;

public class UserDTO {
	
	private Long id;
	private String userName;
	private String userId;
	private String email;
	private Date   dob;
	private List<Long> roles;
	private List<Long> groups;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Long> getRoles() {
		return roles;
	}
	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public static UserDTO getUserDto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUserName(user.getFullName());
		userDTO.setUserId(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setDob(user.getDob());
		List<Long> rolesIds = new ArrayList<>();
		for(Role role : user.getRoles()){
		  rolesIds.add(role.getId());
		}
		userDTO.setRoles(rolesIds);
		List<Long> groupIds = new ArrayList<>();
		for(PingGroup group : user.getGroups()){
			groupIds.add(group.getId());
		}
		userDTO.setGroups(groupIds);
		return userDTO;
	}
	public List<Long> getGroups() {
		return groups;
	}
	public void setGroups(List<Long> groups) {
		this.groups = groups;
	}

}
