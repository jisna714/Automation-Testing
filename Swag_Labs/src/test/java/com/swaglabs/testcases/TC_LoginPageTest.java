package com.swaglabs.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.swaglabs.pageobject.LoginPage;

import com.swaglabs.utilities.Utils;



public class TC_LoginPageTest extends BaseClass{
	
	@Test(priority=1,dataProvider="LoginData")
	public void verifyLoginWithInValidCredentials(String username,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(username);
		Logger.info("entered username");
		
		lp.enterPassword(pwd);
		Logger.info("entered password");
		
		lp.clickonloginbutton();
		Logger.info("clicked login button");
		Thread.sleep(3000);
		
		WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        Logger.info("passed");
		lp.clearusername();
		Logger.info("cleared username");
		Thread.sleep(3000);
		
		lp.clearpassword();
		Logger.info("cleared password");
		Thread.sleep(3000);
		
		
	}
	
	@DataProvider(name="LoginData")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utils.getTestDataFromExcel("Login");
		return data;
	}
	
	
	
	

}
