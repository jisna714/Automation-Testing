package com.junkybooks.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.junkybooks.pageobject.HomePage;
import com.junkybooks.pageobject.LoginPage;
import com.junkybooks.pageobject.MyProfilePage;
import com.junkybooks.pageobject.RegisterPage;
import com.junkybooks.pageobject.ResetPasswordPage;
import com.junkybooks.utilities.Utils;

public class TC_LoginPageTest extends BaseClass{
	
	@Test(priority=1,dataProvider="LoginData")
	public void verifyLoginWithValidCredentials(String email,String pwd) throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonlogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		Logger.info("entered email");
		
		lp.enterPassword(pwd);
		Logger.info("enterd password");
		
		lp.clickonloginbutton();
		Logger.info("clicked login button");
		Thread.sleep(3000);
		
		MyProfilePage mp = new MyProfilePage(driver);
		Assert.assertTrue(mp.getDisplayStatusofDashboardOption(),"Dashboard option is not displayed");
		mp.clickonlogout();
		Logger.info("clicked logout button");
		Thread.sleep(3000);
		
	} 
	@DataProvider(name="LoginData")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utils.getTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority=2,dataProvider="LoginData1")
	public void verifyLoginWithInvalidCredentials(String email,String pwd) throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonlogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		Logger.info("entered email");
		
		lp.enterPassword(pwd);
		Logger.info("enterd password");
		
		lp.clickonloginbutton();
		Logger.info("clicked login button");
		Thread.sleep(3000);
		
		WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		WebElement errorMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Invalid login details";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        okButton.click();
        Logger.info("passed");
	}
	@DataProvider(name="LoginData1")
	public Object[][] supplyTestData1() {
		
		Object[][] data = Utils.getTestDataFromExcel("Login1");
		return data;
	}
	 @Test(priority=3)
	public void verifyResetpasswordonLoginpage() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonlogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.clicklostpassword();
		Logger.info("clicked link");
		Thread.sleep(3000);
		
		ResetPasswordPage rp = new ResetPasswordPage(driver);
		Assert.assertTrue(rp.getDisplayStatusofResetPasswordHeading(),"Reset Password Heading is not displayed");
		Logger.info("passed");
		
	}
	 @Test(priority=4)
	 public void verifyLoginWithoutprovidingcredentials()  throws InterruptedException
	 {
		 HomePage hp=new HomePage(driver);
		 hp.clickonlogin();
			
		 LoginPage lp=new LoginPage(driver);
		 lp.clickonloginbutton();
		 Logger.info("clicked login button");
		 Thread.sleep(3000);
		 
		 WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		 WebElement errorMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
	     String actualErrorMessage = errorMessageElement.getText();
	     String expectedErrorMessage = "Please Enter Email !";
	     Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	     WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
	     okButton.click();
	     Logger.info("passed");
	 }
	 @Test(priority=5)
	 public void  verifyPasswordisEncryptedform() throws InterruptedException
	 {
		    HomePage hp=new HomePage(driver);
			hp.clickonlogin();
			Thread.sleep(3000);
			WebElement passwordField = driver.findElement(By.id("password"));
			String inputType = passwordField.getAttribute("type");
			boolean isEncrypted = "password".equals(inputType);
			Thread.sleep(3000);
			Assert.assertTrue(isEncrypted);
			Logger.info("passed");
	 }
	 @Test(priority=6)
	 public void verifyRegisterlinkonLoginpage() throws InterruptedException
	 {
		 HomePage hp=new HomePage(driver);
		 hp.clickonlogin();
			
		 LoginPage lp=new LoginPage(driver);
		 lp.clickregisterlink();
		 Logger.info("clicked link");
		 Thread.sleep(3000);
		 
		 RegisterPage rg = new RegisterPage(driver);
		 Assert.assertTrue(rg.getDisplayStatusofRegisterHeading(),"Register Heading is not displayed");
		 Logger.info("passed");
	  }
	 @Test(priority=7)
	 public void verifyRequiredfieldsarePresent() throws InterruptedException
	 {
		 HomePage hp=new HomePage(driver);
		 hp.clickonlogin();
		 Thread.sleep(3000);	
		 LoginPage lp=new LoginPage(driver);
		 Assert.assertTrue(lp.getDisplayStatusofEmail(),"Email field is not present");
		 Assert.assertTrue(lp.getDisplayStatusofPassword(),"Password field is not present");
		 Logger.info("passed");
	 }
	 @Test(priority=8)
	 public void verifySymbolOfMandatoryfields() throws InterruptedException
	 {
		 HomePage hp=new HomePage(driver);
		 hp.clickonlogin();
		 Thread.sleep(3000);	
		 LoginPage lp=new LoginPage(driver);
		 Assert.assertTrue(lp.getDisplayStatusofMandatorySymbol(),"Symbol is not present");
		 Logger.info("passed");
	 }
	 
	 
	 

}
