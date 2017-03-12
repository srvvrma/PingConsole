package com.pingconsole.test.rest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest")
public class RestController {
	
	
	@RequestMapping("/index")
	public String getRestApiTestPage() {
		
		
		return "rest/index";
	}

}
