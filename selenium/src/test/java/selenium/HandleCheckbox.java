package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("url");
		driver.manage().window().maximize();
		
		//select specific check box
        driver.findElement(By.xpath("")).click();
        
        //select all the check boxes
        List<WebElement>checkboxes = driver.findElements(By.xpath(""));
        System.out.println("total no of checkboxes:"+checkboxes.size());
        
        for(WebElement chbox:checkboxes)
        {
        	chbox.click();
        }
        
        //select multiple check boxes by choice
        //monday & sunday
        List<WebElement>checkboxes1 = driver.findElements(By.xpath(""));
        System.out.println("total no of checkboxes:"+checkboxes1.size());
        
        for(WebElement chbox:checkboxes1)
        {
        	String checkboxname=chbox.getAttribute("id");
        	if(checkboxname.equals("monday") || checkboxname.equals("sunday"))
        	{
        	chbox.click();
        	}
        }
        
        //select last 2 check boxes
        //total no of check boxes-no of check boxes want to select=starting index
        //7-2=5
        
       int totalcheckboxes=checkboxes.size();
       for(int i=totalcheckboxes-2;i<totalcheckboxes;i++)
       {
    	   checkboxes.get(i).click();
       }
       
       //select 1st 2 check boxes
       int totalcheckboxes1=checkboxes.size();
       for(int i=0;i<totalcheckboxes1;i++)
       {
    	   if(i<2)
    	   {
    		   checkboxes.get(i).click();
    	   }
       }
       
        
	}

}
