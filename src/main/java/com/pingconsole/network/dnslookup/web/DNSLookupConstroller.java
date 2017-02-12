package com.pingconsole.network.dnslookup.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dnsLookup")
public class DNSLookupConstroller {

	private static final String DNS_LOOKUP_INDEX_PAGE = "dnsLookup/index";

	@RequestMapping("/search")
	public String renderDNSLookupIndexPage() {

		return DNS_LOOKUP_INDEX_PAGE;
	}

	@RequestMapping(value="/search" , method = RequestMethod.POST)
	@ResponseBody public String dnsLookupForDomain(@RequestParam("domainName") String host) {
		// method 1
		StringBuilder result = new StringBuilder("");
		result.append(System.getProperty("line.separator"));
		try {
			InetAddress inetAddress = InetAddress.getByName(host);
			// show the Internet Address as name/address
			result.append(inetAddress.getHostName() + " " + inetAddress.getHostAddress());

			Hashtable<String, String> env = new Hashtable<String, String>();
			// env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
			// env.put(Context.PROVIDER_URL,
			// "ldap://localhost:389/o=JNDITutorial");

			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
			// env.put(Context.PROVIDER_URL, "dns://google.com");

			// get the default initial Directory Context
			InitialDirContext iDirC = new InitialDirContext(env);
			// get the DNS records for inetAddress
			Attributes attributes = iDirC.getAttributes("dns:/" + inetAddress.getHostName());
			// get an enumeration of the attributes and print them out
			NamingEnumeration<?> attributeEnumeration = attributes.getAll();
			result.append("");
			result.append(System.getProperty("line.separator"));
			while (attributeEnumeration.hasMore()) {
				result.append("" + attributeEnumeration.next());
				result.append(System.getProperty("line.separator"));
			}
			attributeEnumeration.close();
		} catch (UnknownHostException exception) {
			result.append("ERROR: Cannot access '" + host + "'");
		} catch (NamingException exception) {
			result.append("ERROR: No DNS record for '" + host + "'");
			exception.printStackTrace();
		}
		result.append(System.getProperty("line.separator"));
		// Method 2
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			displayStuff("local host", inetAddress,result);
			result.append(System.getProperty("line.separator"));
			result.append("--------------------------");
			inetAddress = InetAddress.getByName("www.google.com");
			displayStuff("www.google.com", inetAddress,result);
			result.append(System.getProperty("line.separator"));
			result.append("--------------------------");
			InetAddress[] inetAddressArray = InetAddress.getAllByName("saurabhverma.info");
			for (int i = 0; i < inetAddressArray.length; i++) {
				displayStuff("www.google.com #" + (i + 1), inetAddressArray[i],result);
				result.append(System.getProperty("line.separator"));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result.toString();

	}

	public void displayStuff(String whichHost, InetAddress inetAddress, StringBuilder result) {
		result.append("--------------------------");
		result.append(System.getProperty("line.separator"));
		result.append("Which Host:" + whichHost);
		result.append(System.getProperty("line.separator"));
		result.append("Canonical Host Name:" + inetAddress.getCanonicalHostName());
		result.append(System.getProperty("line.separator"));
		result.append("Host Name:" + inetAddress.getHostName());
		result.append(System.getProperty("line.separator"));
		result.append("Host Address:" + inetAddress.getHostAddress());
		result.append(System.getProperty("line.separator"));
	}

}
