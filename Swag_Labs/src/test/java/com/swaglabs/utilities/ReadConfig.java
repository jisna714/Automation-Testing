package com.swaglabs.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties properties;
	
	String path="C:\\Users\\ASUS\\eclipse-workspace\\Swag_Labs\\Configuration\\Config.properties";
	
	//create constructor
	public ReadConfig()
	{
		try {
		
			properties =new Properties();
		    FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getBaseUrl()
	{
		String value=properties.getProperty("baseUrl");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in Config file.");
	}
	
	public String getBrowserl()
	{
		String value=properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in Config file.");
	}
	

}
