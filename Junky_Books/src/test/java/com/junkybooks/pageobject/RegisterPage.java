package com.junkybooks.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver ldriver;
	 
	//create constructor
	public RegisterPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//h2[normalize-space()='Register']")
	WebElement registerheading;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txtFullname;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='cpassword']")
	WebElement txtConfirmPasword;
	
	@FindBy(xpath="//button[@id='signupbtn']")
	WebElement btnRegister;
	
	@FindBy(xpath="//div[@class='login-form']//a[@href='login.php'][normalize-space()='Login']")
	WebElement loginlink;
	
	@FindBy(xpath="//div[@class='login-form']//div[1]//label[1]//span[1]")
	WebElement symbol;
	
	public void enterFullname(String fullname)
	{
		txtFullname.sendKeys(fullname);
	}
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmpassword)
	{
		txtConfirmPasword.sendKeys(confirmpassword);
	}
	public void clickonregisterbutton()
	{
		btnRegister.click();
	}
	public void clickonloginlink()
	{
		loginlink.click();
	}
	
	
	public boolean getDisplayStatusofFullName()
	{
		boolean displayStatus = txtFullname.isDisplayed();
		return displayStatus;
	}
	public boolean getDisplayStatusofEmail()
	{
		boolean displayStatus = txtEmail.isDisplayed();
		return displayStatus;
	}
	public boolean getDisplayStatusofPassword()
	{
		boolean displayStatus = txtPassword.isDisplayed();
		return displayStatus;
	}
	public boolean getDisplayStatusofConfirmPassword()
	{
		boolean displayStatus = txtConfirmPasword.isDisplayed();
		return displayStatus;
	}
	public boolean getDisplayStatusofRegisterHeading()
	{
		boolean displayStatus = registerheading.isDisplayed();
		return displayStatus;
	}
	public boolean getDisplayStatusofSymbol()
	{
		boolean displayStatus = symbol.isDisplayed();
		return displayStatus;
	}
}
