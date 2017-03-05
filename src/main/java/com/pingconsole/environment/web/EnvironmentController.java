package com.pingconsole.environment.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pingconsole.dashboard.service.UserDashboardService;
import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.environment.validator.EnvironmentValidator;
import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.service.GroupService;

@Controller
@RequestMapping("/environment")
public class EnvironmentController {

	@Autowired
	private EnvironmentService environmentService;

	@Autowired
	private EnvironmentValidator environmentValidator;

	@Autowired
	private GroupService groupSerive;

	@Autowired
	private UserDashboardService userDashboardService;

	@RequestMapping("/showAll")
	public String showAllEnvironment(Model model) {
		List<EnvironmentDTO> environementDTOs = environmentService.getAllEnvironment();
		model.addAttribute("environments", environementDTOs);
		return "environment/index";
	}

	@RequestMapping("/showDetails/{id}")
	public String showEnvironmentDetail(Model model, @PathVariable("id") long id) {
		EnvironmentDTO environementDTO = environmentService.getEnvironmentById(id);
		model.addAttribute("environment", environementDTO);
		return "environment/detail";
	}

	@RequestMapping("/getStatus")
	public String getEnvironmentStatus(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Set<PingGroup> groups= userDashboardService.getUserByUserName(user.getUsername()).getGroups();
		for (PingGroup pingGroup : groups) {
			
			
		}
		return "environment/detail";
	}

	@RequestMapping("/create")
	public String showCreateEnvironment(Model model, @RequestParam Long id) {
		model.addAttribute("groups", groupSerive.getAllGroup());
		EnvironmentDTO environmentDTO = null;
		if (id == null) {
			environmentDTO = new EnvironmentDTO();
		} else {
			environmentDTO = environmentService.getEnvironmentById(id);
		}
		model.addAttribute("environmentDTO", environmentDTO);
		return "environment/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showAllEnvironment(Model model, @ModelAttribute("environmentDTO") EnvironmentDTO environmentDTO,
			BindingResult bindingResult) {
		model.addAttribute("groups", groupSerive.getAllGroup());
		environmentValidator.validate(environmentDTO, bindingResult);

		if (bindingResult.hasErrors()) {
			return "environment/create";
		}
		environmentService.createOrUpdate(environmentDTO);
		return "blank";
	}

}
