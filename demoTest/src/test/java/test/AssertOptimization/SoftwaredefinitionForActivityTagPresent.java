package test.AssertOptimization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AssertOptimizationPage.SoftwareDefinitionPage;
import AssertOptimizationPage.WorkStationGroupsPages;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;
import utilities.ReadXLSdata;

public class SoftwaredefinitionForActivityTagPresent extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
	SoftwareDefinitionPage softwareDef = new SoftwareDefinitionPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> activityNameList = null;
	List<String> hostNameExcelList = null;

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void softwareDefinitationForSoftwareTagsCURD() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriverMysql();
		// listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		// listeners.testStepDescription("Step 2: Click on Work Flow");
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		// listeners.testStepDescription("Step 3: Click on Side Navigation bar");
		nav.clickWorkFlowSideNavigationArrow();
		// listeners.testStepDescription("Step 4: Scroll down the navigation");
		workStation.scrollSideNavigationBar();
		workStation.clickAdministration();
		softwareDef.clickSoftwareDefinition();
		driver.switchTo().frame("contentFrame");
		softwareDef.clikSoftwareTagsBtn();
		softwareDef.clickAddNewBtn();
		softwareDef.clickSName("automation_for_activity tag_check");
		softwareDef.clicksSAVEBtn();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		softwareDef.clickBottomBtn();
		softwareDef.clickSoftwareDefinition();
		driver.switchTo().frame("contentFrame");
		softwareDef.clickModifyForactivity();
		activityNameList = softwareDef.getWorkProfilesName();
		boolean check= activityNameList.contains("automation_for_activitytag_check");
		System.out.println(check);

	}

}
