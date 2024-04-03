package test.WorkProfile;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkProfilesPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class WorkProfileForAddingNew  extends BaseTest {
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void AddingNewWorkProfiles () throws InterruptedException
	{
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		//Thread.sleep(4000);
		workProfile.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on Activities");
		nav.clickActivityTab();
		listeners.testStepDescription("Step 4: Click on Work Profiles");
		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Click on AddNew Button");
		workProfile.clickAddNewBtn();
		listeners.testStepDescription("Step 6: Enter the name");
		String name = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		System.out.println(name);
		workProfile.FillNameTxtBox(name);
		listeners.testStepDescription("Step 7: Enter the description");
		String des = RandomStringUtils.randomAlphabetic(10);
		System.out.println(des);
		workProfile.FillDescriptionTxtbox(des);
		//Thread.sleep(1000);
		listeners.testStepDescription("Step 8: Click on Activity On System");
		workProfile.clickAOSBtn();
		listeners.testStepDescription("Step 9: Select application name in  Activity On System");
		workProfile.selectApplicationName();
		listeners.testStepDescription("Step 10: Click on ADD button");
		workProfile.clickOnAddApplicationName();
		//Thread.sleep(1000);
		//workProfile.selectRatingForAOS();
		listeners.testStepDescription("Step 11: Click on Activity Away From System");
		workProfile.clickAWFSBtn();
		listeners.testStepDescription("Step 12: Select any onr activity away from system");
		workProfile.selectAWFS();
		listeners.testStepDescription("Step 13: Click onADD button");
		workProfile.clickAddBtnOnAWFS();
		listeners.testStepDescription("Step 14: Give rating for selected AWFS");
		workProfile.selectRatingForAWFS();
		listeners.testStepDescription("Step 15: Click on Activity Tags");
		workProfile.clickActivityTagsBtn();
		listeners.testStepDescription("Step 16: Click on ADD button");
		workProfile.clickAddOnActivityTagsBtn();
		//Thread.sleep(4000);
		workProfile.moveToAddPage();
		listeners.testStepDescription("Step 17: Slect anyone activity tag");
		workProfile.clickToAddActivityTag();
		listeners.testStepDescription("Step 18: Click on ADD button");;
		workProfile.clickAddActivityTagBtn();
		//Thread.sleep(1000);
		workProfile.moveToparentWindow();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 19: Click onSAVE button");
		workProfile.clickSaveBtn();
		listeners.testStepDescription("Step 20: Close the Success message popup");
		workProfile.clickCloseAggregationPopUp();
		
	}

}
