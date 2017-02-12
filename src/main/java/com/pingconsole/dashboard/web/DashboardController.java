package com.pingconsole.dashboard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pingconsole.auth.repository.UserRepository;


@Controller
public class DashboardController {
  
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = {"/", "/welcome", "/PingConsole"})
  public String getMainPage(Model model) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("currentUser", userRepository.findByUsername(user.getUsername()));
    return "pingConsole";
  }

  @RequestMapping(value = {"/dashboard"})
  public String getDashBoard() {
    return "dashboard/index";
  }



}
