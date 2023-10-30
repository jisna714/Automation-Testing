package com.junkybooks.testcases;

import java.time.Duration;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.junkybooks.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
    
	String url=readConfig.getBaseUrl();
	String browser=readConfig.getBrowserl();
	
	public static WebDriver driver;
	public static Logger Logger;
	
	@BeforeClass
	
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   break;
		   
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
	    default:
	    	driver=null;
	    	break;

		}
	
		//imlicit wait of 10secs
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	     //FOR LOGGING
	     Logger=org.apache.log4j.Logger.getLogger("JunkyBooks");
	     PropertyConfigurator.configure("Log4j2.properties");
	     
	     driver.get(url);
		 Logger.info("url opened");
			
		 driver.manage().window().maximize();
		 Logger.info("window maximized");
	   
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
