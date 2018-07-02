package com.pingconsole.dashboard.web;

import com.pingconsole.auth.repository.UserRepository;
import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.domain.PingGroupVO;
import com.pingconsole.group.service.GroupService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DashboardController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private EnvironmentService environmentService; 

	@RequestMapping(value = { "/", "/welcome", "/PingConsole" })
	public String getMainPage(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("currentUser", userRepository.findByUsername(user.getUsername()));
		model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
		return "pingConsole";
	}

	@RequestMapping(value = { "/dashboard" })
	public String getDashBoard(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.pingconsole.auth.model.User pingUser = userRepository.findByUsername(user.getUsername());
		List<PingGroupVO> groupList = new ArrayList<>();
		PingGroup group = null;
		for (PingGroup pingGroup : pingUser.getGroups()) {
            group = groupService.getOne(pingGroup.getId());
			PingGroupVO groupVO =  pingGroup.getVO();
			groupVO = group.getVO();
			groupVO.setEnvironmentList(new ArrayList<>());
			Hibernate.initialize(group.getEnvironments());
			group.getEnvironments().size();
			for (Environment environment : group.getEnvironments()) {
				groupVO.getEnvironmentList().add(environmentService.getEnvironmentById(environment.getId()));
			}
			groupList.add(groupVO);
		}
		model.addAttribute("groupList", groupList);
		return "dashboard/index";
	}

}
