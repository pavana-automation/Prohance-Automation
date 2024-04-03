package test.WorkProfile;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkProfilesPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class WorkProfileForModification  extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modificationOnWorkProfiles () throws InterruptedException
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
		listeners.testStepDescription("Step 5: Click on Modify button");
		workProfile.clickModifyBtn();
		workProfile.clearDescription();
		listeners.testStepDescription("Step 6: Chance the description");
		String des = RandomStringUtils.randomAlphabetic(6);
		System.out.println(des);
		workProfile.FillDescriptionTxtbox(des);
		listeners.testStepDescription("Step 7: Click on SAVE button");
		workProfile.clickSaveBtn();
		listeners.testStepDescription("Step 8: Close Success message popup");
		workProfile.clickCloseAggregationPopUp();
		
	}

}
