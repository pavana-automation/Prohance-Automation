package test.WorkProfile;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkProfilesPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class WorkProfilesForClone extends BaseTest{
	
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
		listeners.testStepDescription("Step 3: Click on Activities");
		nav.clickActivityTab();
		listeners.testStepDescription("Step 4: Click on Work Profiles");
		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Click on Clone button");
		workProfile.clickCloneBtn();
		listeners.testStepDescription("Step 6: Enter the name");
		String name = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		System.out.println(name);
		workProfile.FillNameTxtBox(name);
		listeners.testStepDescription("Step 7: Click on SAVE button");
		workProfile.clickSaveBtn();
		listeners.testStepDescription("Step 8: Close success message popup");
		workProfile.clickCloseAggregationPopUp();
	}

}
