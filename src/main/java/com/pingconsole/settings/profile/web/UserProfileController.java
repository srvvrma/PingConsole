package com.pingconsole.settings.profile.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pingconsole.auth.model.User;
import com.pingconsole.dashboard.service.UserDashboardService;
import com.pingconsole.group.service.GroupService;
import com.pingconsole.roles.services.RoleService;
import com.pingconsole.users.dto.UserDTO;

@Controller
@RequestMapping("/settings/profile")
public class UserProfileController {
	@Autowired
	private UserDashboardService userDashboardService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private GroupService groupService;

	@RequestMapping("/showProfile")
	public String showAllEnvironment(Model model) {
		model.addAttribute("rolesList", roleService.getAllRoles());
		model.addAttribute("groupList", groupService.getAllGroup());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userDashboardService.getUserByUserName(
				((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername());
		UserDTO userDTO = UserDTO.getUserDto(user);
		model.addAttribute("userName", userDTO.getUserName());
		model.addAttribute("userDTO", userDTO);
		return "settings/profile/index";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}

}
