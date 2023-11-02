package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		String year="2023";
		String month="October";
	    String date="25";
		
		driver.findElement(By.xpath("//div[@id='onwardCal']")).click();//opens datepicker
		
		while(true)
		{
			String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[]=monthyear.split("");
			String mon = arr[0];
			String yr = arr[1];
			
			if(mon.equalsIgnoreCase(month)&& yr.equals(year))
				break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
			
		}
		
		//date selection
		
		List<WebElement>alldates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		for(WebElement ele: alldates)
		{
			String dt=ele.getText();
			
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}
		
	}

}
