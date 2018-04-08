package com.automation.testcases.gurukula;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pagelibrary.gurukula.BranchesPage;
import com.automation.pagelibrary.gurukula.HomePage;
import com.automation.testutilities.TestBase;

public class GurukulaBranchScenarios extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(GurukulaBranchScenarios.class);
	HomePage homepage;
	BranchesPage branchespage;

	@BeforeMethod
	public void setUp()
	{
		
		setupApplication(); 
		logger.info("Browser launched successfully");
		homepage=new HomePage();
		branchespage=new BranchesPage();
		homepage.Login("admin", "admin");
	}
	
	@Test(priority=1,description="Create new branch")
	public void Createbranch() {
		Assert.assertTrue(branchespage.createnewbranch("tester", "12345"));
		logger.info("New Branch created successfully");
	}
	
	@Test(priority=2,description="Search a branch")
	public void Searchbranch() {
		Assert.assertTrue(branchespage.searchbranch("tester"));
		logger.info("Search branch is successful");
	}
	
	@Test(priority=3,description="View the branch")
	public void viewbranch() {
		Assert.assertTrue(branchespage.viewbranch());
		logger.info("View branch successful");
	}
	
	@Test(priority=4,description="Edit a branch")
	public void editbranch() {
		Assert.assertTrue(branchespage.editbranch("ABCDE"));
		logger.info("Edit branch successful");
	}
	
	@Test(priority=5,description="Delete a branch")
	public void deletebranch() {
		Assert.assertTrue(branchespage.deletebranch());
		logger.info("Delete branch successful");
	}
	@AfterMethod
	public void tearDown()
	{
		homepage.Logout();
		closeApplication();
		logger.info("Browser closed successfully");
	}
	
}
