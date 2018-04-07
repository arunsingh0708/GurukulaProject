package com.automation.testutilities;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase
{ 
	protected WebDriver driver;
	public WebDriver setupApplication() 
	{
		if(ConfigRead.getProperty("browsername").equalsIgnoreCase("firefox"))
		{
			 FirefoxDriverManager.getInstance().setup();
			 driver = new FirefoxDriver();
		}
		else if(ConfigRead.getProperty("browsername").equalsIgnoreCase("chrome"))
		{
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
		}
		else if(ConfigRead.getProperty("browsername").equalsIgnoreCase("internetexplorer"))
		{
			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();
		}
		else if(ConfigRead.getProperty("browsername").equalsIgnoreCase("edge"))
		{
			EdgeDriverManager.getInstance().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("please give correct browser name");
		}
			
		 driver.manage().window().maximize();
		 driver.get(ConfigRead.getProperty("applicationurl"));
		 return driver;
	} 
  
	public  void closeApplication()
	{
		driver.quit();
	}
     protected WebDriver getWebDriver() {
         return driver;
     }
     


}
 

