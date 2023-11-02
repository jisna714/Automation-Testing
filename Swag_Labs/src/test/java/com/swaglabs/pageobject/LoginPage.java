package com.swaglabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//create object of webdriver
			WebDriver ldriver;
			 
			//create constructor
			public LoginPage(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements(rdriver,this);
			}
			
			//identify webelements
			@FindBy(id="user-name")
			WebElement txtusername;
			@FindBy(id="password")
			WebElement txtpassword;
			@FindBy(id="login-button")
			WebElement btnLogin;
			
			public void enterUsername(String username)
			{
				txtusername.sendKeys(username);
			}
			public void enterPassword(String password)
			{
				txtpassword.sendKeys(password);
			}
			public void clickonloginbutton()
			{
				btnLogin.click();
			}
            public void clearusername() 
            {
				txtusername.clear();
			}
			public void clearpassword() 
			{
				txtpassword.clear();
			}

}
