package com.pingconsole.group.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.domain.PingGroupVO;
import com.pingconsole.group.service.GroupService;

@Controller
@RequestMapping("/group")
public class GroupController {

  private static final String ERROR = "error:";
  private static final String CODE_ERROR = "Code exist.";
  private static final String NAME_ERROR = "Name exist.";
  private static final String SUCCESS = "sucess:";
  private static final String SUCCESS_MSG = "New Group created.";

  @Autowired
  private GroupService groupService;

  @RequestMapping("/showAll")
  public String getGroup(Model model) {
    List<PingGroup> groups = groupService.getAllGroup();
    model.addAttribute("groups", groups);
    model.addAttribute("group", new PingGroup());
    return "group/index";
  }


  @RequestMapping(value = "/createEdit", method = RequestMethod.POST)
  @ResponseBody
  public String createGroup(Model model, @ModelAttribute("userForm") PingGroupVO pingGroupVO) {
    String result = null;
    if (pingGroupVO.getId() == null) {
      switch (groupService.isGroupExist(pingGroupVO)) {
        case PingGroup.CODE_EXIST:
          result = ERROR + CODE_ERROR;
          break;

        case PingGroup.NAME_EXIST:
          result = ERROR + NAME_ERROR;
          break;

        case PingGroup.NO_ERROR:
          groupService.crateNewGroup(pingGroupVO);
          result = SUCCESS + SUCCESS_MSG;
          break;
      }
    } else {
      groupService.editGroup(pingGroupVO);
      result = SUCCESS + SUCCESS_MSG;
    }

    return result;
  }

  @RequestMapping(value = "/remove", method = RequestMethod.POST)
  @ResponseBody
  public String removeGroup(Model model, @RequestParam("id") Long id) {
    groupService.removeGroup(id);
    return SUCCESS;
  }
}
