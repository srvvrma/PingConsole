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
    @JoinTable(
        name = "roles_privileges", 
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
		roleDTO.setName(this.getName());
		roleDTO.setPrivileges(new ArrayList<>());
		for (Privilege privilege : this.getPrivileges()) {
			roleDTO.getPrivileges().add(privilege.getCode());
		}
		return roleDTO;
	}
}
