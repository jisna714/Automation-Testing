package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobile Phones");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        
        driver.findElement(By.xpath("//span[normalize-space()='iQOO Neo 7 Pro 5G (Dark Storm, 12GB RAM, 256GB Storage) | Snapdragon® 8+ Gen 1 | Independent Gaming Chip | Flagship 50MP OIS Camera | AG Glass Design']")).click();
		
        
        Set<String> window=driver.getWindowHandles();
        List<String>windowlist=new ArrayList<String>(window);
        
        for(String windowid:windowlist) 
        {
        	driver.switchTo().window(windowid);
        }
        
        driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")).click();
        
        driver.quit();
        }

}
