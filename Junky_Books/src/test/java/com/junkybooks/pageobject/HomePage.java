package com.junkybooks.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//create object of webdriver
	WebDriver ldriver;
	 
	//create constructor
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//identify webelements
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(xpath="//a[normalize-space()='Signup']")
	WebElement register;
	
	//identify action on webelement
	public void clickonlogin()
	{
		login.click();
	}
	public void clickonregister()
	{
		register.click();
	}

}
