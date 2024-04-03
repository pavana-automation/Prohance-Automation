package test.WorkProfile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkProfilesPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class WorkProfileForDelete  extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void deletionOnWorkProfiles () throws InterruptedException
	{
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		workProfile.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on Activities");
		nav.clickActivityTab();
		listeners.testStepDescription("Step 4: Click on WorkProfiles");
		nav.clickWorkProfilestab();
		listeners.testStepDescription("Step 5: Click on Work Profiles");
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 6: Click on Delete button");
		workProfile.clickDeleteBtn();
		Thread.sleep(3000);
		listeners.testStepDescription("Step 7: Click on YES button on the popup");
		workProfile.clickYesBtn();
		listeners.testStepDescription("Step 8: Close the Success message popup");
		workProfile.clickCloseAggregationPopUp();
		
	}

}
