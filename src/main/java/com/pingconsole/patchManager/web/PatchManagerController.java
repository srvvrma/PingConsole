package com.pingconsole.patchManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.patchManager.domain.PatchManagerDTO;
import com.pingconsole.patchManager.service.PatchManagerService;

@Controller
@RequestMapping("/patchManager")
public class PatchManagerController {

	@Autowired
	private EnvironmentService environmentService;

	@Autowired
	private PatchManagerService patchManagerService;

	@RequestMapping("/showAll")
	public String showAllPatchManager(Model model) {
		model.addAttribute("patchManagerDTOs", patchManagerService.findAllDTOs());
		return "patchManager/index";
	}

	@RequestMapping("/createUpdate")
	public String showCreatepatchManager(Model model, @RequestParam Long id) {
		PatchManagerDTO patchManagerDTO = null;
		model.addAttribute("environements", environmentService.getAllEnvironment());
		if (id == null) {
			patchManagerDTO = new PatchManagerDTO();
		} else {
			patchManagerDTO = patchManagerService.getPatchManagerDTOById(id);
		}
		model.addAttribute("patchManagerDTO", patchManagerDTO);
		return "patchManager/createUpdate";
	}

	@RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
	public String createUpdatePatchManager(Model model, @ModelAttribute PatchManagerDTO patchManagerDTO) {
		patchManagerService.savePatchManager(patchManagerDTO);
		return "blank";
	}

	@RequestMapping("/executeIndexingTask")
	@ResponseBody
	public String executeIndexingTask(@RequestParam Long id) {
		return patchManagerService.executeIndexingTaskFor(id).toString();
	}

}
