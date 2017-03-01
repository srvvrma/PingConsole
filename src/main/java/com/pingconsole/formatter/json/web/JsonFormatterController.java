package com.pingconsole.formatter.json.web;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/formatter")
public class JsonFormatterController {
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String showJsonFormatterPage(Model model) {
		return "formatter/json";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	@ResponseBody
	public String formatJSON(Model model, @RequestParam("rawJson") String rawJson) {
		ObjectMapper mapper = new ObjectMapper();
		Object json;
		try {
			json = mapper.readValue(rawJson, Object.class);
			String data =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "blank";
	}

}
