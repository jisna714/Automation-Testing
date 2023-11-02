package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Navigations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.snapdeal.com");
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
		
		driver.navigate().back(); //snapdeal
		driver.navigate().forward(); //amazon
		driver.navigate().refresh(); //reload page
	}

}
