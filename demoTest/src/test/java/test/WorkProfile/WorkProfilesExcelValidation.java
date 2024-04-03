package test.WorkProfile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkProfilesPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class WorkProfilesExcelValidation  extends BaseTest{
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	
	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Set<String> workProfileExcelList = null;
	Set<String> workProfileList = null;
	Listeners listeners = new Listeners();
	boolean workprofileCompare=false;
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void cloneOnWorkProfiles () throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavbigationMenubar");
		nav.clickSideNavigationBtn();
		workProfile.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on Activities");
		nav.clickActivityTab();
		listeners.testStepDescription("Step 4: Click on Work Profiles");
		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Click on ALL WORK PROFILES CONFIGURATION excel to download");
		Thread.sleep(2000);
		workProfile.clickAllWorkProfileExcel();
		Thread.sleep(5000);
		listeners.testStepDescription("Step 6: Get List from excel");
		workProfileExcelList = excel.getAllWorkProfilesConfig();
	//	Thread.sleep(5000);
		listeners.testStepDescription("Step 7: Get List from web");
		workProfileList = workProfile.getWorkProfileList();
	//	Thread.sleep(5000);
		listeners.testStepDescription("Step 8: Comparing List from Excel and List from Web");
		for(String ele:workProfileList)
		{
			   String list = workProfileExcelList.contains(ele) ? "Yes" : "No";
			   if(list.equals("Yes"))
			   {
				   workprofileCompare = true;
			   }
		}
		Assert.assertTrue(workprofileCompare);
	}

}
