package com.jbkqa.utilities;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("/Users/rohini/Documents/JavaCodes/jbkqaMavenProjV1/Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is: "+e.getMessage());
		}
		
	}
	
	public String getAppURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserLogin()
	{
		String login = prop.getProperty("userMobile");
		return login;
	}
	
	public String getChromePath()
	{
		String chromepath = prop.getProperty("chromePath");
		return chromepath;
	}

}
