package com.pingconsole.users.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	
	@RequestMapping("/users")
	public String getRoleIndexPage(){
		return "users/index";
	}

}
