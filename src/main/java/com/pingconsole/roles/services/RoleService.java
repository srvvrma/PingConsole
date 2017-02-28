package com.pingconsole.roles.services;

import java.util.List;

import com.pingconsole.roles.dto.RoleDTO;

public interface RoleService {
	
	public List<RoleDTO> getAllRoles();

	public void createUpdate(RoleDTO roleDTO);

	public RoleDTO findRoleById(Long id);

}
