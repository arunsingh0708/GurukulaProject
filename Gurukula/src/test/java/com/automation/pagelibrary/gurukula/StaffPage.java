package com.automation.pagelibrary.gurukula;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.automation.testutilities.TestUtil;

public class StaffPage extends TestUtil {
	private static final Logger logger = LoggerFactory.getLogger(StaffPage.class);
	By entities=By.xpath("//li[@class='dropdown pointer ng-scope']/a[@class='dropdown-toggle']");
	By staff=By.xpath("//*[contains(@href,'#/staff')]");
	By Staffspage=By.xpath(".//h2[text()='Staffs']");
	By editform=By.xpath("//form[@name='editForm']");
	By deleteform=By.xpath("//form[@name='deleteForm']");
	By deleteformbtn=By.xpath("//form[@name='deleteForm']//button[@class='btn btn-danger']//*[text()='Delete']");
	By staffname=By.xpath("//form[@name='editForm']//input[@name='name']");
	By staffbranch=By.xpath("//form[@name='editForm']//select[@name='related_branch']");
	By savestaff=By.xpath("//form[@name='editForm']//button[@class='btn btn-primary']//*[text()='Save']");
	By searchQuery=By.id("searchQuery");
	By viewbranch=By.xpath("//button[@class='btn btn-info btn-sm']");
	By editbranch=By.xpath("//button[@class='btn btn-primary btn-sm']");
	By deletebranch=By.xpath("//button[@class='btn btn-danger btn-sm']");
	By viewtableCol1=By.xpath("//table[@class='table table-striped']//*[text()='Field']");
	By viewtableCol2=By.xpath("//table[@class='table table-striped']//*[text()='Value']");
	By back=By.xpath("//button[@class='btn btn-info']//*[text()='Back']");
	By Staffpage=By.xpath(".//h2[text()='Staffs']");
	By createnewstaff=By.xpath("//button[@class='btn btn-primary']//*[text()='Create a new Staff']");
	By searchstaff=By.xpath("//button[@class='btn btn-info']//*[text()='Search a Staff']");

	public StaffPage() {
		PageFactory.initElements(driver, this);
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
		WebElement Staffname=driver.findElement(staffname);
		Staffname.clear();
		entervalueinfield(Staffname,newname);
		
		WebElement Savebranch=driver.findElement(savestaff);
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

}
