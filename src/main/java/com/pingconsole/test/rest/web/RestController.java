package com.pingconsole.test.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.test.rest.domain.RestAPITestDTO;
import com.pingconsole.test.rest.domain.RestAPITestResultDTO;
import com.pingconsole.test.rest.util.RestTestUtil;

@Controller
@RequestMapping("/rest")
public class RestController {
	@Autowired
	private EnvironmentService environmentService;
	
	
	@RequestMapping("/index")
	public String getRestApiTestPage(Model model) {
		model.addAttribute("restAPITest", new RestAPITestDTO());
		model.addAttribute("INT_ENV", environmentService.getAllIntergration());
		
		return "rest/index";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
    public RestAPITestResultDTO testRestAPI(Model model,@ModelAttribute RestAPITestDTO restAPITestDTO) {
        RestAPITestResultDTO apiTestDTO = RestTestUtil.testRestAPI(restAPITestDTO);
        return apiTestDTO;
    }

}
