package com.automation.testcases.gurukula;
//import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pagelibrary.gurukula.*;
import com.automation.testutilities.TestBase;


public class GurkulaStaffScenarios extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(GurkulaStaffScenarios.class);
	HomePage homepage;
	BranchesPage branchespage;
	StaffPage staffpage;
	@BeforeClass
	public void Createbranch() {
		setUp();
		Assert.assertTrue(branchespage.createnewbranch("ABCDE", "12345"));
		logger.info("New Branch created successfully");
		tearDown();
	}
	
	@AfterClass
	public void Deletebranch() {
		setUp();
		Assert.assertTrue(branchespage.deletebranch());
		logger.info("Delete branch successful");
		tearDown();
	}
	
	@BeforeMethod
	public void setUp()
	{
		setupApplication();
		logger.info("Browser launched successfully");
		homepage=new HomePage();
		branchespage=new BranchesPage();
		staffpage=new StaffPage();
		homepage.Login("admin", "admin");
	}
	
	@Test(priority=1,description="Create new staff")
	public void CreateStaff() {
		Assert.assertTrue(staffpage.createnewstaff("testgurukula", 1));
		logger.info("New Staff created successfully");
	}
	
	@Test(priority=2,description="Search a staff")
	public void Searchstaff() {
		Assert.assertTrue(staffpage.searchstaff("testgurukula"));
		logger.info("Search branch is successful");
	}
	
	@Test(priority=3,description="View a staff")
	public void viewstaff() {
		Assert.assertTrue(staffpage.viewstaff());
		logger.info("View staff successful");
	}
	
	@Test(priority=4,description="Edit a staff")
	public void editstaff() {
		Assert.assertTrue(staffpage.editstaff("ABCDE"));
		logger.info("Edit staff successful");
	}
	
	@Test(priority=5,description="Delete a staff")
	public void deletestaff() {
		Assert.assertTrue(staffpage.deletestaff());
		logger.info("Delete staff successful");
	}
	@AfterMethod
	public void tearDown()
	{
		homepage.Logout();
		closeApplication();
		logger.info("Browser closed successfully");
	}

}
