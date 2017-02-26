package com.pingconsole.privileges.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pingconsole.auth.model.Privilege;
import com.pingconsole.privileges.service.PrivilegeService;


@Controller
@RequestMapping("/privileges")
public class PrivilegesController {

  private static final String AUTHORITIES_INDEX_PAGE = "privileges/index";
  private static final String ALL_AUTHORITIES_LIST = "privileges";

  @Autowired
  private PrivilegeService privilegeService;

  @RequestMapping("/loadAllPrivilages")
  public String renderAllAuthoritieIndexPage(Model model) {
    model.addAttribute(ALL_AUTHORITIES_LIST, privilegeService.getAllPrivilegeList());
    model.addAttribute("privilage", new Privilege());
    return AUTHORITIES_INDEX_PAGE;
  }

  @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
  public String crateUpdatePrivilages(Model model, @ModelAttribute Privilege privilege) {
    privilegeService.createUpdate(privilege);
    return "blank";
  }

}
