package com.pingconsole.environment.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.environment.validator.EnvironmentValidator;
import com.pingconsole.group.service.GroupService;
import com.pingconsole.patch.dto.PingResult;
import com.pingconsole.patch.service.PingResultDAOService;

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
    private PingResultDAOService pingResultDAOService;

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
	@ResponseBody public HashMap<Long, Boolean> getEnvironmentStatus(Model model) {
		HashMap<Long,Boolean> resultMap = new HashMap<>();
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Set<PingGroup> groups= userDashboardService.getUserByUserName(user.getUsername()).getGroups();
//		for (PingGroup pingGroup : groups) {
//			
//		}
		List<PingResult> pingResults = pingResultDAOService.getAllStatus();
		for (PingResult pingResult : pingResults) {
			resultMap.put(pingResult.getKeyid(),pingResult.isResult());
		}
		return resultMap;
	}

	@RequestMapping("/create")
	public String showCreateEnvironment(Model model, @RequestParam Long id) {
		model.addAttribute("groups", groupSerive.getAllGroup());
		model.addAttribute("INT_ENV", environmentService.getAllIntergration());
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
