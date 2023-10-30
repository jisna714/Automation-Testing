package com.junkybooks.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.junkybooks.pageobject.HomePage;
import com.junkybooks.pageobject.LoginPage;
import com.junkybooks.pageobject.ResetPasswordPage;

public class TC_ResetPasswordPageTest extends BaseClass {
	@Test(priority=1)
	public void verifyResetPasswordwithvalidemailID() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonlogin();
		LoginPage lp=new LoginPage(driver);
		lp.clicklostpassword();
		ResetPasswordPage rpp=new ResetPasswordPage(driver);
		rpp.enterEmail("Test@gmail.com");
		Logger.info("entered email");
		rpp.clickonresetbutton();
		Logger.info("clicked button");
		Thread.sleep(2000);
		WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		WebElement successMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
        String actualSuccessMessage = successMessageElement.getText();
        String expectedSucessMessage = "A new password have been sent to your email address" ;
        Assert.assertEquals(expectedSucessMessage, actualSuccessMessage);
        WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        okButton.click();
        Logger.info("passed");
		
	}
	@Test(priority=2)
	public void verifyResetPasswordwithInvalidemailID() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickonlogin();
		LoginPage lp=new LoginPage(driver);
		lp.clicklostpassword();
		ResetPasswordPage rpp=new ResetPasswordPage(driver);
		rpp.enterEmail("t@gmail.com");
		Logger.info("entered email");
		rpp.clickonresetbutton();
		Logger.info("clicked button");
		Thread.sleep(2000);
		WebElement modalOverlay = driver.findElement(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']"));
		WebElement errorMessageElement = modalOverlay.findElement(By.xpath("//div[@class='swal-text']"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Invalid Email address"  ;
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        okButton.click();
        Logger.info("passed");
		
	}
	@Test(priority=3)
	public void verifyLoginlinkonResetPasswordPage()
	{
		HomePage hp=new HomePage(driver);
		hp.clickonlogin();
		LoginPage lp=new LoginPage(driver);
		lp.clicklostpassword();
		ResetPasswordPage rpp=new ResetPasswordPage(driver);
		rpp.clickonLoginlink();
		Logger.info("clicked link");
		Assert.assertTrue(lp.getDisplayStatusofLoginHeading(),"Login Heading is not displayed");
	}
	

}
