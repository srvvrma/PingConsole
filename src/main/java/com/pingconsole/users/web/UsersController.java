package com.pingconsole.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pingconsole.dashboard.service.UserDashboardService;

@Controller
@RequestMapping("/users")
public class UsersController {

	private static final String USER_EDIT_PAGE = "users/edit";
	private static String USER_INDEX_PAGE = "users/index";
	private static String ALL_USER_LIST = "userDTOList";

	@Autowired
	private UserDashboardService userDashboardService;

	@RequestMapping("/loadAllUsers")
	public String renderAllUserIndexPage(Model model){
		model.addAttribute(ALL_USER_LIST, userDashboardService.getAllUserList());
		return USER_INDEX_PAGE;
	}
	
	
	@RequestMapping(value="/edit/{id}")
	public String editUserDetails(Model model,@PathVariable Long id){
		model.addAttribute("userDTO", userDashboardService.getUserDTOByUserId(id));
		return USER_EDIT_PAGE;
	}
	
	

}
