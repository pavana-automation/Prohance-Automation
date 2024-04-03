package test.WorkProfile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkProfilesPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class WorkProfilesDeleteWithDependency extends BaseTest {

	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void cloneOnWorkProfiles () throws InterruptedException
	{
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		workProfile.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on Acitivites");
		nav.clickActivityTab();
		listeners.testStepDescription("Step 4: Click on Acitivites");
		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Click on Teams Sorting");
		workProfile.clickTeamsSorting();
		listeners.testStepDescription("Step 6: Click on DELETE button");
		workProfile.clickDependencyDeleteBtn();
		Thread.sleep(3000);
		listeners.testStepDescription("Step 7: Click on YES button");
		workProfile.clickYesBtn();
		Thread.sleep(2000);
		listeners.testStepDescription("Step 8: Click on CLICK HERE button");
		workProfile.clickClickHereBtn();
		workProfile.moveToparentWindow();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Close the message");
		workProfile.clickCloseAggregationPopUp();
	}
	
}
