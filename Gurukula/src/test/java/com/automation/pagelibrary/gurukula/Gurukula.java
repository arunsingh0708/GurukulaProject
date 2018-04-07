package com.automation.pagelibrary.gurukula;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.automation.testutilities.TestBase;

public class Gurukula {
	WebDriver driver; 
	private static final Logger logger = LoggerFactory.getLogger(Gurukula.class);
	public Gurukula(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	By login = By.linkText("login");
	By username=By.id("username");
	By password=By.id("password");
	By authenticate=By.xpath("//button[text()='Authenticate']");
	By loginsuccess=By.xpath("//*[contains(text(),'You are logged in as user \"admin\"')]");
	By entities=By.xpath("//li[@class='dropdown pointer ng-scope']/a[@class='dropdown-toggle']");
	By branch=By.xpath("//*[contains(@href,'#/branch')]");
	By staff=By.xpath("//*[contains(@href,'#/staff')]");
	By Branchespage=By.xpath(".//h2[text()='Branches']");
	By Staffspage=By.xpath(".//h2[text()='Staffs']");
	By createnewbranch=By.xpath("//button[@class='btn btn-primary']//*[text()='Create a new Branch']");
	By editform=By.xpath("//form[@name='editForm']");
	By deleteform=By.xpath("//form[@name='deleteForm']");
	By deleteformbtn=By.xpath("//form[@name='deleteForm']//button[@class='btn btn-danger']//*[text()='Delete']");
	By branchname=By.xpath("//form[@name='editForm']//input[@name='name']");
	By branchcode=By.xpath("//form[@name='editForm']//input[@name='code']");
	By staffname=By.xpath("//form[@name='editForm']//input[@name='name']");
	By staffbranch=By.xpath("//form[@name='editForm']//select[@name='related_branch']");
	By savebranch=By.xpath("//form[@name='editForm']//button[@class='btn btn-primary']//*[text()='Save']");
	By savestaff=By.xpath("//form[@name='editForm']//button[@class='btn btn-primary']//*[text()='Save']");
	By searchQuery=By.id("searchQuery");
	By searchbranch=By.xpath("//button[@class='btn btn-info']//*[text()='Search a Branch']");
	By viewbranch=By.xpath("//button[@class='btn btn-info btn-sm']");
	By editbranch=By.xpath("//button[@class='btn btn-primary btn-sm']");
	By deletebranch=By.xpath("//button[@class='btn btn-danger btn-sm']");
	By viewtableCol1=By.xpath("//table[@class='table table-striped']//*[text()='Field']");
	By viewtableCol2=By.xpath("//table[@class='table table-striped']//*[text()='Value']");
	By back=By.xpath("//button[@class='btn btn-info']//*[text()='Back']");
	By Staffpage=By.xpath(".//h2[text()='Staffs']");
	By createnewstaff=By.xpath("//button[@class='btn btn-primary']//*[text()='Create a new Staff']");
	By searchstaff=By.xpath("//button[@class='btn btn-info']//*[text()='Search a Staff']");
	By account=By.xpath("//li[@class='dropdown pointer']/a[@class='dropdown-toggle']//b[@class='caret']");
	By accountdropdown=By.xpath("//li[@class='dropdown pointer open']//ul[@class='dropdown-menu']");
	By logout=By.xpath("//a[@ng-click='logout()']");
	
	
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
	/**
     * Creates new branch.
     * @param name,@param code
     */
	public boolean createnewbranch(String name,String code) {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(branch);
		WebElement Branch=driver.findElement(branch);
		clickWebelement(Branch);
		
		waitForElementToDisplay(createnewbranch);
		WebElement CreateBranch=driver.findElement(createnewbranch);
		clickWebelement(CreateBranch);
		waitForElementToDisplay(editform);
		
		
		WebElement Branchname=driver.findElement(branchname);
		entervalueinfield(Branchname,name);
		
		
		WebElement Branchcode=driver.findElement(branchcode);
		entervalueinfield(Branchcode,code);
		
		
		WebElement Savebranch=driver.findElement(savebranch);
		clickWebelement(Savebranch);
		
		waitForElementToDisplay(deletebranch);
				return true;
		}catch(Exception e) {
			logger.warn("Create branch unsuccessful");
			return false;
		}
		
		}
	/**
     * Search a branch.
     * @param name
     */
	
	public boolean searchbranch(String name) {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(branch);
		WebElement Branch=driver.findElement(branch);
		clickWebelement(Branch);
		/*Search a Branch which do not exist*/
		waitForElementToDisplay(searchQuery);
		WebElement Searchquery=driver.findElement(searchQuery);
		entervalueinfield(Searchquery,"PQRST");
		WebElement Searchbranch=driver.findElement(searchbranch);
		clickWebelement(Searchbranch);
		
		
		Searchquery.clear();
		entervalueinfield(Searchquery,name);
		clickWebelement(Searchbranch);
		waitForElementToDisplay(By.xpath("//*[contains(text(),'"+name+"')]"));
		WebElement searchelement=driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
		Assert.assertTrue(searchelement.isDisplayed());
		
		return true;
		}catch(Exception e) {
			logger.warn("search branch not successful.");
			return false;
		}
	}
	/**
     * View a branch.
     */
	public boolean viewbranch() {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		
		waitForElementToDisplay(branch);
		WebElement Branch=driver.findElement(branch);
		clickWebelement(Branch);
		waitForElementToDisplay(viewbranch);
		WebElement Viewbranch=driver.findElement(viewbranch);
		clickWebelement(Viewbranch);
		waitForElementToDisplay(back);
		return true;
		}catch(Exception e) {
			logger.warn("View branch unsuccessful");
			return false;
		}
		
		
	}
	/**
     * Edit a branch.
     * @param newname
     */
	public boolean editbranch(String newname) {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(branch);
		WebElement Branch=driver.findElement(branch);
		clickWebelement(Branch);
		
		waitForElementToDisplay(editbranch);
		WebElement Editstaff=driver.findElement(editbranch);
		clickWebelement(Editstaff);
		
		waitForElementToDisplay(editform);
		
		WebElement Staffname=driver.findElement(staffname);
		Staffname.clear();
		entervalueinfield(Staffname,newname);
		
		
		WebElement Savestaff=driver.findElement(savebranch);
		clickWebelement(Savestaff);
		navigate_refresh();
		waitForElementToDisplay(deletebranch);
		
		return true;
		
		}catch(Exception e) {
			logger.warn("Edit branch unsuccessful");
			return false;
		}
		
	}
	/**
     * Delete a branch.
     * @param newname
     */
	
	public boolean deletebranch() {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		
		clickWebelement(Entities);
		waitForElementToDisplay(branch);
		WebElement Branch=driver.findElement(branch);
		clickWebelement(Branch);
		
		waitForElementToDisplay(deletebranch);
		WebElement Deletebranch=driver.findElement(deletebranch);
		clickWebelement(Deletebranch);
		
		waitForElementToDisplay(deleteform);
		WebElement Deleteformbtn=driver.findElement(deleteformbtn);
		clickWebelement(Deleteformbtn);
		navigate_refresh();
		waitForElementToDisplay(Branchespage);
		return true;
		}catch(Exception e) {
			logger.warn("delete branch unsuccessful");
			return false;
		}
			
	}
	/**
     *Creates new staff.
     * @param name,@param branchval
     */
	
	public boolean createnewstaff(String name,int branchval) {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(staff);
		WebElement Staff=driver.findElement(staff);
		clickWebelement(Staff);
		
		waitForElementToDisplay(createnewstaff);
		WebElement CreateStaff=driver.findElement(createnewstaff);
		clickWebelement(CreateStaff);
		waitForElementToDisplay(editform);
	
		WebElement Staffname=driver.findElement(staffname);
		entervalueinfield(Staffname,name);
		
		WebElement Staffbranch=driver.findElement(staffbranch);
		selectElementByIndexMethod(Staffbranch,1);
		
		WebElement Savestaff=driver.findElement(savestaff);
		clickWebelement(Savestaff);
		
		waitForElementToDisplay(deletebranch);
		return true;
		}catch(Exception e) {
			logger.warn("Create staff unsuccessful");
			return false;
		}
		
		}
	/**
     * Search a staff.
     * @param name
     */

	public boolean searchstaff(String name) {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(staff);
		WebElement Staff=driver.findElement(staff);
		clickWebelement(Staff);
		/*Search a Staff which do not exist*/
		waitForElementToDisplay(searchQuery);
		WebElement Searchquery=driver.findElement(searchQuery);
		entervalueinfield(Searchquery,"PQRST");
		WebElement Searchstaff=driver.findElement(searchstaff);
		clickWebelement(Searchstaff);
		
		
		Searchquery.clear();
		entervalueinfield(Searchquery,name);
		clickWebelement(Searchstaff);
		waitForElementToDisplay(By.xpath("//*[contains(text(),'"+name+"')]"));
		WebElement searchelement=driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
		Assert.assertTrue(searchelement.isDisplayed());
		
		return true;
		}catch(Exception e) {
			logger.warn("search staff not successful.");
			return false;
		}
	}
	/**
     * View a staff.
     */
	
	public boolean viewstaff() {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(staff);
		WebElement Staff=driver.findElement(staff);
		clickWebelement(Staff);
		waitForElementToDisplay(viewbranch);
		WebElement Viewstaff=driver.findElement(viewbranch);
		clickWebelement(Viewstaff);
		waitForElementToDisplay(back);
		return true;
		}catch(Exception e) {
			logger.warn("View staff unsuccessful");
			return false;
			
		}
		
		
	}
	
	/**
     * Edit a staff.
     * @param newname
     */

	public boolean editstaff(String newname) {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(staff);
		WebElement Staff=driver.findElement(staff);
		clickWebelement(Staff);
		
		waitForElementToDisplay(editbranch);
		WebElement Editbranch=driver.findElement(editbranch);
		clickWebelement(Editbranch);
		
		waitForElementToDisplay(editform);
		WebElement Staffname=driver.findElement(branchname);
		Staffname.clear();
		entervalueinfield(Staffname,newname);
		
		WebElement Savebranch=driver.findElement(savebranch);
		clickWebelement(Savebranch);
		navigate_refresh();
		waitForElementToDisplay(deletebranch);
		return true;
		}catch(Exception e) {
			logger.warn("edit staff unsuccessful");
			return false;
		}
		
	}	
	
	/**
     * Delete a staff.
     */
	
	public boolean deletestaff() {
		try {
		waitForElementToDisplay(entities);
		WebElement Entities=driver.findElement(entities);
		clickWebelement(Entities);
		
		waitForElementToDisplay(staff);
		WebElement Staff=driver.findElement(staff);
		clickWebelement(Staff);
		
		waitForElementToDisplay(deletebranch);
		WebElement Deletestaff=driver.findElement(deletebranch);
		clickWebelement(Deletestaff);
		
		waitForElementToDisplay(deleteform);
		WebElement Deleteformbtn=driver.findElement(deleteformbtn);
		clickWebelement(Deleteformbtn);
		navigate_refresh();
		waitForElementToDisplay(Staffspage);
		return true;
		}catch(Exception e) {
			logger.warn("delete staff unsuccessful");
			return false;
		}
			
	}
	/**
     * Waits for element to display.
     * @param locator
     */
    public void waitForElementToDisplay(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
   
	
	/** 
	 * To Refresh page.
	 */
	public void navigate_refresh() {
	driver.navigate().refresh();
	}

	/** 
	 * click Webelement.
	 * @param element
	 */
	public void clickWebelement(WebElement element) {
	try {
		boolean status = element.isEnabled();
		if(status) {
	
		element.click();
		}
	

	} catch (Exception e) {
	System.out.println("Element is not enabled");
	e.printStackTrace();
	}
	}

	/** 
	 * Select element from dropdown.
	 * @param element,@param value
	 */
	public void selectElementByValueMethod(WebElement element,
	String value) {
	try{
	Select selectitem = new Select(element);
	selectitem.selectByValue(value);
	}catch (Exception e) {
	System.out.println("Element is not enabled");
	e.printStackTrace();
	}

	}


	/** 
	 * Enter the value in editbox.
	 * @param element,@param val
	 */
	public void entervalueinfield(WebElement element,String val) {
	try {
		boolean status = element.isEnabled();
		if(status) {
		element.sendKeys(val);
		}
	

	}catch (Exception e) {
	System.out.println("Element is not enabled");
	e.printStackTrace();
	}
	}
	
	public void selectElementByIndexMethod(WebElement element, int index) {
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
		}
	
}
