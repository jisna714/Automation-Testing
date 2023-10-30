package com.junkybooks.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	//create object of webdriver
			WebDriver ldriver;
			 
			//create constructor
			public MyProfilePage(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements(rdriver,this);
			}
			
			//identify webelements
			@FindBy(xpath="//a[normalize-space()='Logout']")
			WebElement logout;
			
			@FindBy(xpath="//a[normalize-space()='Dashboard']")
			WebElement dashboardoption;
			
			@FindBy(xpath="//div[@id='checkaccountVerify']")
			WebElement accountverify; 
			
			public void clickonlogout()
			{
				logout.click();
			}
			
			public boolean getDisplayStatusofDashboardOption()
			{
				boolean displayStatus = dashboardoption.isDisplayed();
				return displayStatus;
			}
			public boolean getDisplayStatusofAccountverification()
			{
				boolean displayStatus = accountverify.isDisplayed();
				return displayStatus;
			}

}
