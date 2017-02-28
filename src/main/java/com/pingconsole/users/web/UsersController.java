package com.pingconsole.users.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pingconsole.dashboard.service.UserDashboardService;
import com.pingconsole.group.service.GroupService;
import com.pingconsole.roles.services.RoleService;
import com.pingconsole.users.dto.UserDTO;
import com.pingconsole.users.validator.UserDtoValidator;

@Controller
@RequestMapping("/users")
public class UsersController {

  private static final String USER_EDIT_PAGE = "users/edit";
  private static String USER_INDEX_PAGE = "users/index";
  private static String ALL_USER_LIST = "userDTOList";

  @Autowired
  private UserDashboardService userDashboardService;

  @Autowired
  private UserDtoValidator userDtoValidator;
  
  @Autowired
  private RoleService roleService;
  
  @Autowired
  private GroupService groupService;

  @RequestMapping("/loadAllUsers")
  public String renderAllUserIndexPage(Model model) {
    model.addAttribute(ALL_USER_LIST, userDashboardService.getAllUserList());
    return USER_INDEX_PAGE;
  }

  @RequestMapping(value = "/edit/{id}")
  public String editUserDetails(Model model, @PathVariable Long id) {
    model.addAttribute("rolesList", roleService.getAllRoles());
    model.addAttribute("groupList", groupService.getAllGroup());
    model.addAttribute("userDTO", userDashboardService.getUserDTOByUserId(id));
    return USER_EDIT_PAGE;
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveUserDetails(Model model, @ModelAttribute("userDTO") UserDTO userDTO,
      BindingResult bindingResult) {
    userDtoValidator.validate(userDTO, bindingResult);
    model.addAttribute("rolesList", roleService.getAllRoles());
    model.addAttribute("groupList", groupService.getAllGroup());
    if (bindingResult.hasErrors()) {
      return USER_EDIT_PAGE;
    } else {
      userDashboardService.saveUserDtoInUser(userDTO);
    }
    return "blank";
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
}
