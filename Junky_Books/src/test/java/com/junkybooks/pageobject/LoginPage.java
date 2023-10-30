package com.junkybooks.pageobject;

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
		@FindBy(css="#email")
		WebElement txtEmail;
		
		@FindBy(id="password")
		WebElement txtPassword;
		
		@FindBy(id="loginbtn")
		WebElement btnLogin;
		
		@FindBy(id="rememberme")
		WebElement chkboxRemember;
		
		@FindBy(linkText="Lost your password?")
		WebElement linklost;
		
		@FindBy(linkText="Register")
		WebElement registerlink;
		
		@FindBy(xpath="//div[@class='login-form']//div[1]//label[1]//span[1]")
		WebElement mandatorysymbol;
		
		@FindBy(xpath="//h2[normalize-space()='Login']")
		WebElement loginheading;
		
		
		//identify action on webelement
		public void enterEmail(String email)
		{
			txtEmail.sendKeys(email);
		}
		
		public void enterPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		public void clickonloginbutton()
		{
			btnLogin.click();
		}
		public void tickcheckbox()
		{
			chkboxRemember.click();
		}
		public void clicklostpassword()
		{
			linklost.click();
		}
		public void clickregisterlink()
		{
			registerlink.click();
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
		public boolean getDisplayStatusofMandatorySymbol()
		{
			boolean displayStatus = mandatorysymbol.isDisplayed();
			return displayStatus;
		}
		public boolean getDisplayStatusofLoginHeading()
		{
			boolean displayStatus = loginheading.isDisplayed();
			return displayStatus;
		}
		
}
