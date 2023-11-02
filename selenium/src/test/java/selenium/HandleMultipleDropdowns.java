package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdowns {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("url");
		driver.manage().window().maximize();
		
		//using generic method
		
		WebElement noofemps=driver.findElement(By.name("NoOfEmployees"));
		selectoptionfromdropdown(noofemps,"16-20");
		
		WebElement industry=driver.findElement(By.name("Industry"));
		selectoptionfromdropdown(industry,"Healthcare");
		
		WebElement country=driver.findElement(By.name("Country"));
		selectoptionfromdropdown(country,"Ghana");
		
		
	}
      public static void selectoptionfromdropdown(WebElement ele,String value)
      {
    	  Select drp=new Select(ele);
    	  List<WebElement>alloptions=drp.getOptions();
  		for(WebElement option:alloptions)
  		{
  			if(option.getText().equals(value))
  			{
  				option.click();
  				break;
  			}
  		}
      }
}
