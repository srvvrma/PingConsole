package com.pingconsole.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class SOAPClientSAAJ {
	
	public static void main(String[] args) {
		try {
			System.out.println(isAvailable("wsdl"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isAvailable(String webServiceUrl) throws IOException{

	    // first check if there is a WiFi/data connection available... then:

	    URL url = new URL(webServiceUrl);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestProperty("Connection", "close");
	    connection.setConnectTimeout(10000); // Timeout 10 seconds
	    connection.connect();

	    // If the web service is available
	    if (connection.getResponseCode() == 200) {
	        return true;
	    }
	    else return false;
	}

}