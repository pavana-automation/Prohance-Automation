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
import test.Listeners;
import utilities.ReadXLSdata;

public class SoftwareDefinitionForSoftwareTagsExcelexport extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
	SoftwareDefinitionPage softwareDef = new SoftwareDefinitionPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> softwareTagsList = null;
	List<String> softwareTagsExcelList = null;

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void softwareDefinitationForSoftwareTagsCURD() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver6688();
		 //listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		// listeners.testStepDescription("Step 2: Click on Work Flow");
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		 //listeners.testStepDescription("Step 3: Click on Side Navigation bar");
		nav.clickWorkFlowSideNavigationArrow();
		 //listeners.testStepDescription("Step 4: Scroll down the navigation");
		workStation.scrollSideNavigationBar();
		 //listeners.testStepDescription("Step 5: Click on Administration");
		workStation.clickAdministration();
		 //listeners.testStepDescription("Step 6: Click on SoftwareDefinition");
		softwareDef.clickSoftwareDefinition();
		driver.switchTo().frame("contentFrame");
		//listeners.testStepDescription("Step 7: Click on SoftwareTags");
		softwareDef.clikSoftwareTagsBtn();
		softwareTagsList = softwareDef.getSoftwareTagsList();
		softwareDef.clickSoftwareDefinitionExcel();
		softwareTagsExcelList = excel.getSoftwareTagsExcel();
		boolean check = softwareTagsList.equals(softwareTagsExcelList);
		System.out.println(check);
		
	}

}
