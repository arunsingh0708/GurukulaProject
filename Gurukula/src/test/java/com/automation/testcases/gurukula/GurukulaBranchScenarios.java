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

public class GurukulaBranchScenarios extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(GurukulaBranchScenarios.class);
	private TestBase tb;
	private WebDriver driver;
	Gurukula Page;
	@BeforeMethod
	public void setUp()
	{
		tb= new TestBase();
		driver = tb.setupApplication(); 
		logger.info("Browser launched successfully");
		Page = new Gurukula(driver);
		Page.Login("admin", "admin");
	}
	
	@Test(priority=1,description="Create new branch")
	public void Createbranch() {
		Assert.assertTrue(Page.createnewbranch("tester", "12345"));
		logger.info("New Branch created successfully");
	}
	
	@Test(priority=2,description="Search a branch")
	public void Searchbranch() {
		//Assert.assertTrue(Page.searchbranch("tester"));
		Assert.assertTrue(Page.searchbranch("tester"));
		logger.info("Search branch is successful");
	}
	
	@Test(priority=3,description="View the branch")
	public void viewbranch() {
		Assert.assertTrue(Page.viewbranch());
		logger.info("View branch successful");
	}
	
	@Test(priority=4,description="Edit a branch")
	public void editbranch() {
		Assert.assertTrue(Page.editbranch("ABCDE"));
		logger.info("Edit branch successful");
	}
	
	@Test(priority=5,description="Delete a branch")
	public void deletebranch() {
		Assert.assertTrue(Page.deletebranch());
		logger.info("Delete branch successful");
	}
	@AfterMethod
	public void tearDown()
	{
		Page.Logout();
		tb.closeApplication();
		logger.info("Browser closed successfully");
	}
	
}
