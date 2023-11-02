package com.swaglabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {

	//create object of webdriver
	WebDriver ldriver;
	 
	//create constructor
	public InformationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//identify webelements
	@FindBy(id="first-name")
	WebElement txtFirstname;
	@FindBy(id="last-name")
	WebElement txtLastname;
	@FindBy(id="postal-code")
	WebElement txtPostalcode;
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement btn;
	
	public void enterfirstname(String firstname)
	{
		txtFirstname.sendKeys(firstname);
	}
	public void enterlastname(String lastname)
	{
		txtLastname.sendKeys(lastname);
	}
	public void enterpostalcode(String postalcode)
	{
		txtPostalcode.sendKeys(postalcode);
	}
	public void clickonbutton()
	{
		btn.click();
	}
	
	
}
