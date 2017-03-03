package com.pingconsole.patch.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
public final class PingUtil {
    
	final static Logger logger = Logger.getLogger(PingUtil.class);
    
    public static boolean checkUrl(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
            ImageIO.setUseCache(false);
            ImageIO.read(url);
            return true;
        } catch (MalformedURLException e) {
        	e.printStackTrace();
        	logger.error("This is error 1: " + e.getMessage());
            return false;
        } catch (IOException e) { // NOSONAR
        	e.printStackTrace();
        	logger.error("This is error 2: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean isWebserviceAvailable(String webServiceUrl){

	    // first check if there is a WiFi/data connection available... then:

	    URL url;
		try {
			url = new URL(webServiceUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestProperty("Connection", "close");
		    connection.setConnectTimeout(10000); // Timeout 10 seconds
		    connection.connect();

		    // If the web service is available
		    if (connection.getResponseCode() == 200) {
		        return true;
		    }
		    else return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	    
	}

}
