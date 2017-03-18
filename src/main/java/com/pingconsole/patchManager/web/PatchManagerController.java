package com.pingconsole.patchManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.patchManager.domain.PatchManagerDTO;

@Controller
@RequestMapping("/patchManager")
public class PatchManagerController {
  
  @Autowired
  private EnvironmentService environmentService;
  
  @RequestMapping("/createUpdate")
  public String showCreateEnvironment(Model model, @RequestParam Long id) {
    PatchManagerDTO patchManagerDTO = null;
    model.addAttribute("environements", environmentService.getAllEnvironment());
    if (id == null) {
      patchManagerDTO = new PatchManagerDTO();
    } else {
      //patchManagerDTO = roleService.findRoleById(id);
    }
    model.addAttribute("patchManagerDTO", patchManagerDTO);
    return "patchManager/createUpdate";
  }

}
