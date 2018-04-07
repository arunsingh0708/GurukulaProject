package com.automation.testcases.gurukula;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pagelibrary.gurukula.Gurukula;
import com.automation.testutilities.ConfigRead;
import com.automation.testutilities.TestBase;


public class GurkulaStaffScenarios extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(GurkulaStaffScenarios.class);
	private TestBase tb;
	private WebDriver driver;
	Gurukula Page;
	@BeforeClass
	public void Createbranch() {
		setUp();
		Assert.assertTrue(Page.createnewbranch("ABCDE", "12345"));
		logger.info("New Branch created successfully");
		tearDown();
	}
	
	@AfterClass
	public void Deletebranch() {
		setUp();
		Assert.assertTrue(Page.deletebranch());
		logger.info("Delete branch successful");
		tearDown();
	}
	
	@BeforeMethod
	public void setUp()
	{
		tb= new TestBase();
		driver = tb.setupApplication(); 
		logger.info("Browser launched successfully");
		Page = new Gurukula(driver);
		Page.Login("admin", "admin");
	}
	
	@Test(priority=1,description="Create new staff")
	public void CreateStaff() {
		Assert.assertTrue(Page.createnewstaff("testgurukula", 1));
		logger.info("New Staff created successfully");
	}
	
	@Test(priority=2,description="Search a staff")
	public void Searchstaff() {
		Assert.assertTrue(Page.searchstaff("testgurukula"));
		logger.info("Search branch is successful");
	}
	
	@Test(priority=3,description="View a staff")
	public void viewstaff() {
		Assert.assertTrue(Page.viewstaff());
		logger.info("View staff successful");
	}
	
	@Test(priority=4,description="Edit a staff")
	public void editstaff() {
		Assert.assertTrue(Page.editstaff("ABCDE"));
		logger.info("Edit staff successful");
	}
	
	@Test(priority=5,description="Delete a staff")
	public void deletestaff() {
		Assert.assertTrue(Page.deletestaff());
		logger.info("Delete staff successful");
	}
	@AfterMethod
	public void tearDown()
	{
		Page.Logout();
		tb.closeApplication();
		logger.info("Browser closed successfully");
	}

}
