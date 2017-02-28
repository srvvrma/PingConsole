package com.pingconsole.auth.model;

import javax.persistence.*;

import com.pingconsole.roles.dto.RoleDTO;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
  private Long id;
  private String name;
  private String code;
  private String description;
  private Set<User> users;
  private Set<Privilege> privileges;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  @ManyToMany(mappedBy = "roles")
  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @ManyToMany
  @JoinTable(name = "roles_privileges",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
  public Set<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(Set<Privilege> privileges) {
    this.privileges = privileges;
  }

  public RoleDTO convertToDto() {
    RoleDTO roleDTO = new RoleDTO();
    roleDTO.setId(this.getId());
    roleDTO.setName(this.getName());
    roleDTO.setCode(this.getCode());
    StringBuilder privilegeList = new StringBuilder();
    for (Privilege privilege : this.getPrivileges()) {
    	privilegeList.append(privilege.getId().toString());
    	privilegeList.append(",");
    }
    roleDTO.setPrivileges((privilegeList.length() > 0 ? privilegeList.substring(0, privilegeList.length() - 1): ""));
    return roleDTO;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}
}
