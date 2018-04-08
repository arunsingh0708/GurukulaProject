package com.automation.pagelibrary.gurukula;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.automation.testutilities.TestUtil;

public class HomePage extends TestUtil {
	private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
	By login = By.linkText("login");
	By username=By.id("username");
	By password=By.id("password");
	By authenticate=By.xpath("//button[text()='Authenticate']");
	By loginsuccess=By.xpath("//*[contains(text(),'You are logged in as user \"admin\"')]");
	By account=By.xpath("//li[@class='dropdown pointer']/a[@class='dropdown-toggle']//b[@class='caret']");
	By accountdropdown=By.xpath("//li[@class='dropdown pointer open']//ul[@class='dropdown-menu']");
	By logout=By.xpath("//a[@ng-click='logout()']");
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
     * Login to application.
     * @param uname,@param pwd
     */
	public void Login(String uname,String pwd) {
	try {waitForElementToDisplay(login);
	WebElement Login = driver.findElement(login);
	clickWebelement(Login);
	waitForElementToDisplay(username);
	
	WebElement Username = driver.findElement(username);
	entervalueinfield(Username,uname);
	
	
	WebElement Password = driver.findElement(password);
	entervalueinfield(Password,pwd);
	

	WebElement Authenticate = driver.findElement(authenticate);
	clickWebelement(Authenticate);
	
	waitForElementToDisplay(loginsuccess);
	logger.info("Login successful");
	}
	catch (Exception e) {
		logger.warn("login unsuccessful");
	}
	
	}
	/**
     * Logout from application.
     */
	public void Logout() {
		try {
		waitForElementToDisplay(account); 
		//waitForElementTobeClickable(account);
		WebElement Account=driver.findElement(account);
		clickWebelement(Account);
		waitForElementToDisplay(logout);
		WebElement Logout=driver.findElement(logout);
		clickWebelement(Logout);
		waitForElementToDisplay(login);
		logger.info("Logout successful");
		}catch(Exception e) {
			logger.warn("logout unsuccessful");
		}
		
	}

}
