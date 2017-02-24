package com.pingconsole.settings.profile.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings/profile")
public class UserProfileController {
  
  @RequestMapping("/showProfile")
  public String showAllEnvironment(Model model) {
    return "settings/profile/index";
  }

}
