package com.swaglabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//create object of webdriver
	WebDriver ldriver;
	 
	//create constructor
	public ProductPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//identify webelements
	@FindBy(xpath="//div[@class='inventory_list']//div[1]//div[3]//button[1]")
	WebElement AddToCartBtn;
	
	@FindBy(xpath="//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']")
	WebElement Cartbtn;
	
	@FindBy(xpath="//a[normalize-space()='CHECKOUT']")
	WebElement checkoutbtn;
	
	@FindBy(xpath="//button[normalize-space()='Open Menu']")
	WebElement btn;
	
	@FindBy(xpath="//div[@class='product_label']")
	WebElement productheading;
	
	@FindBy(xpath="//div[@class='subheader']")
	WebElement heading;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	public void clickonaddtocartbutton()
	{
		AddToCartBtn.click();
	}
	public void clickoncartbutton()
	{
		Cartbtn.click();
	}
	public void clickoncheckoutbutton()
	{
		checkoutbtn.click();
	}
	public void clickonbutton()
	{
		btn.click();
	}
	public void clickonlogoutbutton()
	{
		logout.click();
	}
	
	public boolean getDisplayStatusofProductHeading()
	{
		boolean displayStatus = productheading.isDisplayed();
		return displayStatus;
	}
	public boolean getDisplayStatusofHeading()
	{
		boolean displayStatus = heading.isDisplayed();
		return displayStatus;
	}


}
