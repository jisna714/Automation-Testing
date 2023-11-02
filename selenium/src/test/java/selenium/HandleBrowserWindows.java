package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("url");
		driver.manage().window().maximize();
 
		//getWindowHandle()
		//getWindowHandles()
		
		//getWindowHandle()
		String windowID=driver.getWindowHandle(); //return ID of the single browser window
		System.out.println( windowID);
		
		driver.findElement(By.xpath("")).click();//opens another browser
		
		//getWindowHandles()
		Set<String>WindowIDs=driver.getWindowHandles();//return ID's of multiple browser
		
		//First method - iterator()
		Iterator<String>it=WindowIDs.iterator();
		
		String parentwindowID=it.next();
		String childwindowID=it.next();
		
		System.out.println("Parent window Id:"+parentwindowID);
		System.out.println("child window Id:"+childwindowID);
		
		//How to use windowID's for switching
		driver.switchTo().window(parentwindowID);
		System.out.println("Parent window title:"+ driver.getTitle());
		
		driver.switchTo().window(childwindowID);
		System.out.println("Child window title:"+ driver.getTitle());
		
		//for each loop more than 2
		for(String winid:WindowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
		}
		
		   driver.quit();//close all browser windows
		   
		   //close specific window by choice
		   
		   for(String winid:WindowIDs)
			{
				String title=driver.switchTo().window(winid).getTitle();
				if(title.equals(childwindowID) || title.equals("another window3") )
				{
					driver.close();
				}
			}
		
		
	}

}
