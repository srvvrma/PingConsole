package com.pingconsole.environmentUser.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.environmentUser.domain.EnvironmentUserDTO;
import com.pingconsole.environmentUser.service.EnvironmentUserService;
import com.pingconsole.environmentUser.validator.EnvironmentUserValidator;

@Controller
@RequestMapping("/environmentUser")
public class EnvironmentUserController {

	@Autowired
	private EnvironmentService environmentService;

	@Autowired
	private EnvironmentUserService environmentUserService;

	@Autowired
	private EnvironmentUserValidator environmentUserValidator;
	
	@RequestMapping("/showAll")
	public String showAllEnvironment(Model model) {
		List<EnvironmentUserDTO> environementUserDTOs = environmentUserService.getAllEnvironmentUsers();
		model.addAttribute("environementUsers", environementUserDTOs);
		return "environmentUser/index";
	}

	@RequestMapping("/create")
	public String showCreateEnvironmentUser(Model model, @RequestParam Long id) {
		EnvironmentUserDTO environmentUserDTO = null;
		if (id == null) {
			environmentUserDTO = new EnvironmentUserDTO();
		} else {
			environmentUserDTO = environmentUserService.getEnvironmentUserById(id);
		}
		model.addAttribute("environmentUserDTO", environmentUserDTO);
		model.addAttribute("ENVIRONMENTS", environmentService.getAllEnvironment());
		return "environmentUser/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEnvironmentUser(Model model,
			@ModelAttribute("environmentDTO") EnvironmentUserDTO environmentUserDTO, BindingResult bindingResult) {
		model.addAttribute("ENVIRONMENTS", environmentService.getAllEnvironment());
		environmentUserValidator.validate(environmentUserDTO, bindingResult);

		if (bindingResult.hasErrors()) {
			return "environmentUser/create";
		}
		environmentUserService.saveOrUpdateEnvironmentUser(environmentUserDTO);
		return "blank";
	}

}
