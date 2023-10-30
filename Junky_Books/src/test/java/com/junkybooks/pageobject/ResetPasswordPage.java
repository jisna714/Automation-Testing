package com.junkybooks.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {

	WebDriver ldriver;
	 
	//create constructor
	public ResetPasswordPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Reset Password']")
	WebElement resetpasswordheading;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtemail;
	
	@FindBy(xpath="//button[@id='repassword']")
	WebElement btnreset;
	
	@FindBy(xpath="//a[@href='login.html']")
	WebElement loginlink;
	
	public void enterEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void clickonresetbutton()
	{
		btnreset.click();
	}
	public void clickonLoginlink()
	{
		loginlink.click();
	}
	
	public boolean getDisplayStatusofResetPasswordHeading()
	{
		boolean displayStatus = resetpasswordheading.isDisplayed();
		return displayStatus;
	}

}
