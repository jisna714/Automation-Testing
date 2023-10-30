package com.junkybooks.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.junkybooks.pageobject.HomePage;
import com.junkybooks.pageobject.LoginPage;
import com.junkybooks.pageobject.MyProfilePage;
import com.junkybooks.pageobject.RegisterPage;

public class TC_RegisterPageTest extends BaseClass {
	
	@Test(priority=1)
	public void verifyRegisterWithAllDetails() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonregister();
		
		RegisterPage rg=new RegisterPage(driver);
		rg.enterFullname("Test");
		Logger.info("entered fullname");
		rg.enterEmail("testtttest@gmail.com");
		Logger.info("entered email");
		rg.enterPassword("Test@1234");
		Logger.info("entered password");
		rg.enterConfirmPassword("Test@1234");
		Logger.info("entered confirmpassword");
		rg.clickonregisterbutton();
		Logger.info("clicked register button");
		
		MyProfilePage mp = new MyProfilePage(driver);
		Assert.assertTrue(mp.getDisplayStatusofAccountverification(),"Account verification is not displayed");
		mp.clickonlogout();
		Logger.info("clicked logout button");
		Thread.sleep(3000);
	}
	@Test(priority=2)
	 public void verifyRequiredfieldsarePresent() throws InterruptedException
	 {
		 HomePage hp=new HomePage(driver);
		 hp.clickonregister();
		 Thread.sleep(3000);	
		 RegisterPage rg=new RegisterPage(driver);
		 Assert.assertTrue(rg.getDisplayStatusofFullName(),"Fullname field is not present");
		 Assert.assertTrue(rg.getDisplayStatusofEmail(),"Email field is not present");
		 Assert.assertTrue(rg.getDisplayStatusofPassword(),"Password field is not present");
		 Assert.assertTrue(rg.getDisplayStatusofConfirmPassword(),"Confirm Password field is not present");
		 Logger.info("passed");
	 }
	@Test(priority=3)
	public void verifySymbolOfMandatoryfields() throws InterruptedException
	 {
		 HomePage hp=new HomePage(driver);
		 hp.clickonregister();
		 Thread.sleep(3000);	
		 RegisterPage rg=new RegisterPage(driver);
		 Assert.assertTrue(rg.getDisplayStatusofSymbol(),"Symbol is not present");
		 Logger.info("passed");
	 }
	@Test(priority=4)
	 public void  verifyPasswordisEncryptedform() throws InterruptedException
	 {
		    HomePage hp=new HomePage(driver);
			hp.clickonregister();
			Thread.sleep(3000);
			WebElement passwordField = driver.findElement(By.id("password"));
			String inputType = passwordField.getAttribute("type");
			boolean isEncrypted = "password".equals(inputType);
			Thread.sleep(3000);
			Assert.assertTrue(isEncrypted);
			Logger.info("passed");
	 }
	@Test(priority=5)
	public void verifyRegisterwithInvalidPassword() throws InterruptedException
	
	{
		HomePage hp=new HomePage(driver);
		hp.clickonregister();
		Thread.sleep(2000);
		
		RegisterPage rg=new RegisterPage(driver);
		rg.enterFullname("Test");
		Logger.info("entered fullname");
		rg.enterEmail("tes@gmail.com");
		Logger.info("entered email");
		rg.enterPassword("Te4");
		Logger.info("entered password");
		rg.enterConfirmPassword("Te34");
		Logger.info("entered confirmpassword");
		rg.clickonregisterbutton();
		Logger.info("clicked register button");
		
		 WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		 WebElement errorMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
	     String actualErrorMessage = errorMessageElement.getText();
	     String expectedErrorMessage = "Your Password can't be less than 6 Characters";
	     Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	     WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
	     okButton.click();
	     Logger.info("passed");
	}
	@Test(priority=6)
	public void verifyPasswordMismatch() throws InterruptedException {
		
		HomePage hp=new HomePage(driver);
		hp.clickonregister();
		Thread.sleep(2000);
		
		RegisterPage rg=new RegisterPage(driver);
		rg.enterFullname("Test");
		Logger.info("entered fullname");
		rg.enterEmail("tes@gmail.com");
		Logger.info("entered email");
		rg.enterPassword("Test@12354");
		Logger.info("entered password");
		rg.enterConfirmPassword("Te34");
		Logger.info("entered confirmpassword");
		rg.clickonregisterbutton();
		Logger.info("clicked register button");
		
		 WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		 WebElement errorMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
	     String actualErrorMessage = errorMessageElement.getText();
	     String expectedErrorMessage ="Your Passwords Do not Match";
	     Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	     WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
	     okButton.click();
	     Logger.info("passed");
		}
	@Test(priority=7)
	public void verifyRegisterwithAlreadyregisteredID() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonregister();
		Thread.sleep(2000);
		
		RegisterPage rg=new RegisterPage(driver);
		rg.enterFullname("Test");
		Logger.info("entered fullname");
		rg.enterEmail("jisnajose140@gmail.com");
		Logger.info("entered email");
		rg.enterPassword("Test@12354");
		Logger.info("entered password");
		rg.enterConfirmPassword("Test@12354");
		Logger.info("entered confirmpassword");
		rg.clickonregisterbutton();
		Logger.info("clicked register button");
		
		 WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		 WebElement errorMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
	     String actualErrorMessage = errorMessageElement.getText();
	     String expectedErrorMessage ="This email is already registered";
	     Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	     WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
	     okButton.click();
	     Logger.info("passed");
		
	}
	@Test(priority=8)
	public void verifyLoginlinkonRegisterPage() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonregister();
		Thread.sleep(2000);
		
		RegisterPage rg=new RegisterPage(driver);
		rg.clickonloginlink();
		Logger.info("clicked link");
		Thread.sleep(2000);
		 
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.getDisplayStatusofLoginHeading(),"Login Heading is not displayed");
		Logger.info("passed");
	}
	
	@Test(priority=8)
	 public void verifyLoginWithoutprovidingdetails()  throws InterruptedException
	 {
		 HomePage hp=new HomePage(driver);
		 hp.clickonregister();
			
		 RegisterPage rg=new RegisterPage(driver);
		 rg.clickonregisterbutton();
		 Logger.info("clicked login button");
		 Thread.sleep(3000);
		 
		 WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		 WebElement errorMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
	     String actualErrorMessage = errorMessageElement.getText();
	     String expectedErrorMessage = "Please Enter Full Name !";
	     Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	     WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
	     okButton.click();
	     Logger.info("passed");
	 }
	
	

}
