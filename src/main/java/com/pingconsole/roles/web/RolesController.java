package com.pingconsole.roles.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RolesController {
	@RequestMapping("/roles")
	public String getRoleIndexPage(){
		return "roles/index";
	}

}
