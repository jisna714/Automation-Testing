package com.swaglabs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.pageobject.InformationPage;
import com.swaglabs.pageobject.LoginPage;
import com.swaglabs.pageobject.ProductPage;

public class TC_ProductPageTest extends BaseClass {
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials() throws InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
		
		lp.enterUsername("standard_user");
		Logger.info("entered username");
		
		lp.enterPassword("secret_sauce");
		Logger.info("entered password");
		
		lp.clickonloginbutton();
		Logger.info("clicked login button");
		Thread.sleep(3000);
		
		ProductPage pp=new ProductPage(driver);
		Assert.assertTrue(pp.getDisplayStatusofProductHeading(),"Product Heading is not displayed");
		Logger.info("passed");
		
	}
	@Test(priority=2)
	public void verifyCartFunctionality() throws InterruptedException{
		
		ProductPage pp=new ProductPage(driver);
		pp.clickonaddtocartbutton();
		Logger.info("clicked add to cart button");
		Thread.sleep(3000);
		
		pp.clickoncartbutton();
		Logger.info("clicked cart button");
		Thread.sleep(3000);
		Assert.assertTrue(pp.getDisplayStatusofHeading(),"Cart Heading is not displayed");
		Logger.info("passed");
		
		pp.clickoncheckoutbutton();
		Logger.info("clicked checkout button");
		Thread.sleep(3000);
		Assert.assertTrue(pp.getDisplayStatusofHeading(),"Checkout Heading is not displayed");
		Logger.info("passed");
		
		
	}
	@Test(priority=3)
	public void verifyInformationpage() throws InterruptedException{
		
		InformationPage ip=new InformationPage(driver);
		ip.enterfirstname("Jisna");
		Logger.info("entered firstname");
		ip.enterlastname("Jose");
		Logger.info("entered lastname");
		ip.enterpostalcode("682316");
		Logger.info("entered postalcode");
		ip.clickonbutton();
		Logger.info("clicked button");
		Thread.sleep(3000);
		
		ProductPage pp=new ProductPage(driver);
		pp.clickonbutton();
		Logger.info("clicked button");
		pp.clickonlogoutbutton();
		Logger.info("clicked logoutbutton");
		Thread.sleep(3000);
	}

}
