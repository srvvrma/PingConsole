package com.pingconsole.environment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pingconsole.environment.domain.EnvironementDTO;
import com.pingconsole.environment.service.EnvironmentService;

@Controller
@RequestMapping("/environment")
public class EnvironmentController {
	
	@Autowired
	private EnvironmentService environmentService;
	
	@RequestMapping("/showAll")
	public String showAllEnvironment(Model model){
		List<EnvironementDTO> environementDTOs = environmentService.getAllEnvironment();
		model.addAttribute("environments", environementDTOs);
		return "environment/index";
	}
	
	@RequestMapping("/create")
	public String showCreateEnvironment(Model model){
		List<EnvironementDTO> environementDTOs = environmentService.getAllEnvironment();
		model.addAttribute("environments", environementDTOs);
		return "environment/create";
	}

}
