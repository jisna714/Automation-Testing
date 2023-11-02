package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementVsFindElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//findElemt() -- return the single WebElement
		
		WebElement searchbox =driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchbox.sendKeys("abc");
		
		
		//
		WebElement footer =driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(footer.getText());
		
		//findElements() --- returns multiple webElements
		List<WebElement> links =driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println("No of elements captured:"+ links.size());
		
		for(WebElement ele:links)
		
		{
			System.out.println(ele.getText());
		}
	}
	
}


