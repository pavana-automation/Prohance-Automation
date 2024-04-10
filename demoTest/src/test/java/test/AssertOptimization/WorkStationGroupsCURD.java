package test.AssertOptimization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AssertOptimizationPage.WorkStationGroupsPages;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import WorkFlowPage.CustomAttributeBulkUploadPages;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;
import utilities.ReadXLSdata;

public class WorkStationGroupsCURD extends BaseTest {

	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;
	

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void workStationGroups() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriverMysql();
		 listeners.testStepDescription("Step 1: Login to ProHance Application");
		 loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		 listeners.testStepDescription("Step 2: Click on Work Flow");
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		 listeners.testStepDescription("Step 3: Click on Side Navigation bar");
		nav.clickWorkFlowSideNavigationArrow();
		 listeners.testStepDescription("Step 4: Scroll down the navigation");
		workStation.scrollSideNavigationBar();
		 listeners.testStepDescription("Step 5: Click on Administration tab");
		workStation.clickAdministration();
		 listeners.testStepDescription("Step 6: Click on WorkStationGroups tab");
		workStation.clickWorkStationGroups();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 7: Click on Add new button");
		workStation.clickAddNew();
		listeners.testStepDescription("Step 8: Enter the name");
		workStation.clickName("automation_1");
		listeners.testStepDescription("Step 9: Enter Description");
		workStation.clickDescription("automation testing");
		listeners.testStepDescription("Step 10: Click on Location");
		workStation.clickLocation();
		listeners.testStepDescription("Step 11: Enter scan time");
		workStation.clickScanTime("5");
		listeners.testStepDescription("Step 12: Click on Save button");
		workStation.clickSAVEBtn();
		listeners.testStepDescription("Step 13: Compare on Add successfull message");
		boolean checkAdd = workStation.clickAddMsg();
		Assert.assertTrue(checkAdd);
		listeners.testStepDescription("Step 14: Click on PopUp cloase icon");
		workStation.clickCloseXIconBtn();
		//modify
		listeners.testStepDescription("Step 15: Click on Back button");
		workStation.clickBackBtn();
		listeners.testStepDescription("Step 16: Click on Modify button");
		workStation.clickModifyBtn();
		listeners.testStepDescription("Step 17: Click on location");
		workStation.clickLocation();
		listeners.testStepDescription("Step 18: Enetr the scan time");
		workStation.clickScanTime("10");
		listeners.testStepDescription("Step 19: Click on Save button");
		workStation.clickSAVEBtn();
		listeners.testStepDescription("Step 20: Compare on Modify successfull message");
		boolean checkMod = workStation.clickModifyMsg();
		Assert.assertTrue(checkMod);
		listeners.testStepDescription("Step 21: Click on PopUp close icon");
		workStation.clickCloseXIconBtn();
		//delete
		listeners.testStepDescription("Step 22: Click on Back button");
		workStation.clickBackBtn();
		listeners.testStepDescription("Step 23: Click on Delete button");
		workStation.clickDeleteBtn();
		Thread.sleep(1000); //
		listeners.testStepDescription("Step 24: Click on YES button");
		workStation.clickYESBtn();
		listeners.testStepDescription("Step 25: Compare on Delete successfull message");
		boolean checkDel  = workStation.clickDeleteMsg();
		Assert.assertTrue(checkDel);
		listeners.testStepDescription("Step 26: Click on PopUp close icon");
		workStation.clickCloseXIconBtn();

	}
}

