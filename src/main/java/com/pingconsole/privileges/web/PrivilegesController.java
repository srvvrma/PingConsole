package com.pingconsole.privileges.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pingconsole.privileges.service.PrivilegeService;


@Controller
@RequestMapping("/privileges")
public class PrivilegesController {
	
	private static final String AUTHORITIES_INDEX_PAGE = "privileges/index";
	private static final String ALL_AUTHORITIES_LIST = "privileges";
	
	@Autowired
	private PrivilegeService privilegeService;

	@RequestMapping("/loadAllAuthorities")
	public String renderAllAuthoritieIndexPage(Model model){
		model.addAttribute(ALL_AUTHORITIES_LIST, privilegeService.getAllAuthoritiesList());
		return AUTHORITIES_INDEX_PAGE;
	}

}
