package com.pingconsole.roles.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pingconsole.roles.dto.RoleDTO;
import com.pingconsole.roles.services.RoleService;

@Controller
@SessionAttributes("roleDTOs")
public class RolesController {
	
	private static String ROLE_INDEX = "roles/index";
	private static String ROLES_SESSION_ATTR = "roleDTOs";
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/roles")
	public String getRoleIndexPage(Model model){
		List<RoleDTO> roleDTOs = roleService.getAllRoles();
		model.addAttribute(ROLES_SESSION_ATTR, roleDTOs);
		return ROLE_INDEX;
	}

}
