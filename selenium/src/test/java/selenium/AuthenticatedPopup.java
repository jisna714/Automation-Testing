package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatedPopup {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		//syntax
		//https://username:password@url
		//https://admin:pass@the-internet.herokuapp.com/basic_auth
		
        
	}

}
