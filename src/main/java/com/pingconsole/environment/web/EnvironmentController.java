package com.pingconsole.environment.web;

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
import com.pingconsole.environment.validator.EnvironmentValidator;

@Controller
@RequestMapping("/environment")
public class EnvironmentController {

  @Autowired
  private EnvironmentService environmentService;

  @Autowired
  private EnvironmentValidator environmentValidator;

  @RequestMapping("/showAll")
  public String showAllEnvironment(Model model) {
    List<EnvironmentDTO> environementDTOs = environmentService.getAllEnvironment();
    model.addAttribute("environments", environementDTOs);
    return "environment/index";
  }

  @RequestMapping("/create")
  public String showCreateEnvironment(Model model,@RequestParam Long id) {
    EnvironmentDTO environmentDTO = null;
    if(id == null){
      environmentDTO = new EnvironmentDTO();
    }else{
      environmentDTO = environmentService.getEnvironmentById(id);
    }
    model.addAttribute("environmentDTO", environmentDTO);
    return "environment/create";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String showAllEnvironment(Model model,
      @ModelAttribute("environmentDTO") EnvironmentDTO environmentDTO,
      BindingResult bindingResult) {
    environmentValidator.validate(environmentDTO, bindingResult);

    if (bindingResult.hasErrors()) {
      return "environment/create";
    }
    environmentService.createOrUpdate(environmentDTO);
    return "blank";
  }


}
