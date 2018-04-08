package com.automation.pagelibrary.gurukula;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.automation.testutilities.*;

public class BranchesPage extends TestUtil {
	private static final Logger logger = LoggerFactory.getLogger(BranchesPage.class);
	
	By entities=By.xpath("//li[@class='dropdown pointer ng-scope']/a[@class='dropdown-toggle']");
	By branch=By.xpath("//*[contains(@href,'#/branch')]");
	By Branchespage=By.xpath(".//h2[text()='Branches']");
	By createnewbranch=By.xpath("//button[@class='btn btn-primary']//*[text()='Create a new Branch']");
	By branchname=By.xpath("//form[@name='editForm']//input[@name='name']");
	By branchcode=By.xpath("//form[@name='editForm']//input[@name='code']");
	By editform=By.xpath("//form[@name='editForm']");
	By deleteform=By.xpath("//form[@name='deleteForm']");
	By deleteformbtn=By.xpath("//form[@name='deleteForm']//button[@class='btn btn-danger']//*[text()='Delete']");
	By savebranch=By.xpath("//form[@name='editForm']//button[@class='btn btn-primary']//*[text()='Save']");
	By searchQuery=By.id("searchQuery");
	By searchbranch=By.xpath("//button[@class='btn btn-info']//*[text()='Search a Branch']");
	By viewbranch=By.xpath("//button[@class='btn btn-info btn-sm']");
	By editbranch=By.xpath("//button[@class='btn btn-primary btn-sm']");
	By deletebranch=By.xpath("//button[@class='btn btn-danger btn-sm']");
	By back=By.xpath("//button[@class='btn btn-info']//*[text()='Back']");
	
	public BranchesPage() {
		PageFactory.initElements(driver, this);
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
		navigate_refresh();
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
		
		WebElement Branchname=driver.findElement(branchname);
		Branchname.clear();
		entervalueinfield(Branchname,newname);
		
		
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

}
