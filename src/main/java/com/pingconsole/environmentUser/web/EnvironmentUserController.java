package com.pingconsole.environmentUser.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.environmentUser.domain.EnvironmentUserDTO;
import com.pingconsole.environmentUser.service.EnvironmentUserService;

@Controller
@RequestMapping("/environmentUser")
public class EnvironmentUserController {
  
  @Autowired
  private EnvironmentService environmentService;
  
  @Autowired
  private EnvironmentUserService environmentUserService; 

  @RequestMapping("/create")
  public String showCreateEnvironment(Model model, @RequestParam Long id) {
    EnvironmentUserDTO environmentUserDTO = null;
    if (id == null) {
      environmentUserDTO = new EnvironmentUserDTO();
    } else {
      environmentUserDTO = environmentUserService.getEnvironmentUserById(id);
    }
    model.addAttribute("environmentUserDTO", environmentUserDTO);
    model.addAttribute("INT_ENV", environmentService.getAllIntergration());
    return "environmentUser/create";
  }

}
