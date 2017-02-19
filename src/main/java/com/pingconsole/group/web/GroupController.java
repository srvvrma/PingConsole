package com.pingconsole.group.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.service.GroupService;

@Controller
@RequestMapping("/group")
public class GroupController {
	
	@Autowired
	private GroupService groupService;

	@RequestMapping("/showAll")
	public String getGroup(Model model) {
		List<PingGroup> groups = groupService.getAllGroup();
		model.addAttribute("groups", groups);
		model.addAttribute("group", new PingGroup());
		return "group/index";
	}
	
	@RequestMapping("/edit")
	public String editGroup(Model model) {
		List<PingGroup> groups = groupService.getAllGroup();
		model.addAttribute("groups", groups);
		return "group/index";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createGroup(Model model) {
		model.addAttribute("group", new PingGroup());
		return "group/create";
	}


}
