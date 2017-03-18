package com.pingconsole.test.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.test.rest.domain.RestAPITest;

@Controller
@RequestMapping("/rest")
public class RestController {
	@Autowired
	private EnvironmentService environmentService;
	
	
	@RequestMapping("/index")
	public String getRestApiTestPage(Model model) {
		model.addAttribute("restAPITest", new RestAPITest());
		model.addAttribute("INT_ENV", environmentService.getAllIntergration());
		
		return "rest/index";
	}

}
