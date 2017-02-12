package com.pingconsole.network.whois.web;

import java.io.IOException;
import java.net.SocketException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.net.whois.WhoisClient;

@Controller
@RequestMapping("/whoislookup")
public class WhoIsLookupController {
	
	private static final String WHOIS_INDEX_PAGE = "whois/index";
	
	private WhoisClient whois = new WhoisClient();

	@RequestMapping("/search")
	public String renderAllAuthoritieIndexPage(){
		
		return WHOIS_INDEX_PAGE;
	}
	
	@RequestMapping(value="/search" , method = RequestMethod.POST)
	@ResponseBody public String getWhois(@RequestParam("domainName") String domainName) {

		StringBuilder result = new StringBuilder("");
		try {

			//default is internic.net
			whois.connect(WhoisClient.DEFAULT_HOST);
			String whoisData1 = whois.query("=" + domainName);
			result.append(whoisData1);
			whois.disconnect();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

}
