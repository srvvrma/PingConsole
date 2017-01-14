package com.pingconsole.users.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	
	private static String USER_INDEX_PAGE = "users/index";
	
	private static String ALL_USER_LIST = "userList";
	
	@RequestMapping("/users")
	public String getRoleIndexPage(Model model){
		return USER_INDEX_PAGE;
	}

}
