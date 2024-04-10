package test.AssertOptimization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
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

public class SoftwareDefinitationForSoftwareTagsCURD extends BaseTest {

	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
	SoftwareDefinitionPage softwareDef = new SoftwareDefinitionPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;

	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void softwareDefinitationForSoftwareTagsCURD() throws InterruptedException, EncryptedDocumentException, IOException {
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
		 listeners.testStepDescription("Step 5: Click on Administration");
		workStation.clickAdministration();
		 listeners.testStepDescription("Step 6: Click on SoftwareDefinition");
		softwareDef.clickSoftwareDefinition();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 7: Click on SoftwareTags");
		softwareDef.clikSoftwareTagsBtn();
		listeners.testStepDescription("Step 8: Click on Add new button");
		softwareDef.clickAddNewBtn();
		listeners.testStepDescription("Step 9: Enter the name");
		softwareDef.clickSName("automation_1");
		listeners.testStepDescription("Step 10: Enter Description");
		softwareDef.clickSDescription("automation_text description");
		listeners.testStepDescription("Step 11: Click on Save buton");
		softwareDef.clicksSAVEBtn();
		listeners.testStepDescription("Step 12: Compare the add success message");
		boolean checkAdd = softwareDef.clicksAddMsg();
		System.out.println(checkAdd);
		Assert.assertTrue(checkAdd);
		listeners.testStepDescription("Step 13: Click on PopUp close icon");
		softwareDef.clickCloseXIconBtn();
		listeners.testStepDescription("Step 14: Click on Modify button");
		softwareDef.clickModifyBtn();
		listeners.testStepDescription("Step 15: Enter the description");
		softwareDef.clickSDescriptionForModify();
		listeners.testStepDescription("Step 16: Click on Save button");
		softwareDef.clicksSAVEBtn();
		listeners.testStepDescription("Step 17: Compare Modify success message");
		boolean checkMod = softwareDef.clicksModifyMsg();
		Assert.assertTrue(checkMod);
		listeners.testStepDescription("Step 18: Click on PopUp close icon");
		softwareDef.clickCloseXIconBtn();
		listeners.testStepDescription("Step 19: Click on Delete button");
		workStation.clickDeleteBtn();
		Thread.sleep(1000);
		 listeners.testStepDescription("Step 20: Click on YES button");
		workStation.clickYESBtn();
		listeners.testStepDescription("Step 21: Compare the Delete success message");
		boolean checkDel = softwareDef.clicksDeleteMsg();
		Assert.assertTrue(checkDel);
		listeners.testStepDescription("Step 22: Click on PopUp close icon");
		workStation.clickCloseXIconBtn();

	}
	

}
