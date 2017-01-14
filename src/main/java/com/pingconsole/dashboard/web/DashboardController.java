package com.pingconsole.dashboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	@RequestMapping(value = {"/", "/welcome","/PingConsole"})
	public String getMainPage(){
		return "neoPingConsole";
	}
	
	@RequestMapping(value = {"/dashboard"})
	public String getDashBoard(){
		return "dashboard/index";
	}
	
	

}
