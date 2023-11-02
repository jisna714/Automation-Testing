package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement>links=driver.findElements(By.tagName("a"));
		 int brokenlinks=0;
		 for(WebElement ele:links)
		 {
			 String url=ele.getAttribute("href");
			 
			 if(url==null || url.isEmpty())
			 {
				 System.out.println("URL is empty");
				 continue;
			 }
			
			 @SuppressWarnings("deprecation")
			URL link=new URL(url);
			 try 
			 {
				 HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
				 httpconn.connect();
				 if(httpconn.getResponseCode()>=400)
				 {
					 System.out.println(httpconn.getResponseCode()+url+" is"+" Broken link");
					brokenlinks++;
				 }
				 else
				 {
					 System.out.println(httpconn.getResponseCode()+url+" is"+" Valid link");
				 }
			} 
			 
			 catch (MalformedURLException e) {
				
			 }
			}
		 System.out.println("No of broken links:" +brokenlinks);
		 driver.quit();
		 
	}

}
