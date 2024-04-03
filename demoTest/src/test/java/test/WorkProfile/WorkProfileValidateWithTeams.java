package test.WorkProfile;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkProfilesPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class WorkProfileValidateWithTeams  extends BaseTest{

	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
	Listeners listeners = new Listeners();
	Set<String> workProfileListFromTeams = null;
	Set<String> workProfileList = null;
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void cloneOnWorkProfiles () throws InterruptedException
	{
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		workProfile.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on USERS");
		workProfile.clickUsersBtn();
		listeners.testStepDescription("Step 4: Click on Teams");
		Thread.sleep(1000);
		workProfile.clickTeamsBtn();
		driver.switchTo().frame("contentFrame");
		//Thread.sleep(1000);
		//listeners.testStepDescription("Step 5: Click on Modify button");
		workProfile.clickOnTeamsModifyBtn();
		//listeners.testStepDescription("Step 6: Get Work Profiles list from teams");
		workProfileListFromTeams = workProfile.getWorkProfilesName();
		listeners.testStepDescription("Step 7:Click on BACk button");
		workProfile.clickBackBtn();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		listeners.testStepDescription("Step 8:Click on bottom arrow");
		workProfile.clickBottomArrom();
		Thread.sleep(1000);
		listeners.testStepDescription("Step 9: Click on Activities");
		nav.clickActivityTab();
		listeners.testStepDescription("Step 10: Click on Work Profiles");
		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 11: Get Work Profiles list from Work Profiles");
		workProfileList = workProfile.getWorkProfileList();
		listeners.testStepDescription("Step 12: Compare list from Teams and list from Workprofiles");
		boolean result = workProfileListFromTeams.containsAll(workProfileList);
		Assert.assertTrue(result);
	}
}
