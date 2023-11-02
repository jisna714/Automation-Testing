package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
		WebElement drpcountryEle=driver.findElement(By.id("input-country"));
		
		Select drpcountry=new Select(drpcountryEle);
		
		//drpcountry.selectByVisibleText("Denmark");
		//drpcountry.selectByValue("10");
		//drpcountry.selectByIndex(13);
		
		//selecting option from dropdown without using methods
		
		List<WebElement>alloptions=drpcountry.getOptions();
		for(WebElement option:alloptions)
		{
			if(option.getText().equals("Cuba"))
			{
				option.click();
				break;
				
			}
		}
		
		}
}
