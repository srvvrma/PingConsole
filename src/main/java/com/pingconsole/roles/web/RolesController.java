package com.pingconsole.roles.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pingconsole.privileges.service.PrivilegeService;
import com.pingconsole.roles.dto.RoleDTO;
import com.pingconsole.roles.services.RoleService;

@Controller
@SessionAttributes("roleDTOs")
public class RolesController {

  private static String ROLE_INDEX = "roles/index";
  private static String ROLES_SESSION_ATTR = "roleDTOs";

  @Autowired
  private RoleService roleService;

  @Autowired
  private PrivilegeService privilegeService;

  @RequestMapping("/roles")
  public String getRoleIndexPage(Model model) {
    List<RoleDTO> roleDTOs = roleService.getAllRoles();
    model.addAttribute(ROLES_SESSION_ATTR, roleDTOs);
    return ROLE_INDEX;
  }

  @RequestMapping("/roles/createUpdate")
  public String showCreateEnvironment(Model model, @RequestParam Long id) {
    RoleDTO roleDTO = null;
    model.addAttribute("privileges", privilegeService.getAllPrivilegeList());
    if (id == null) {
      roleDTO = new RoleDTO();
    } else {
      roleDTO = roleService.findRoleById(id);
    }
    model.addAttribute("roleDTO", roleDTO);
    return "roles/createUpdate";
  }

  @RequestMapping(value = "/roles/createUpdate", method = RequestMethod.POST)
  public String crateUpdateEnvironment(Model model,@ModelAttribute RoleDTO roleDTO) {
	  roleService.createUpdate(roleDTO);
    
    return "blank";
  }

}
