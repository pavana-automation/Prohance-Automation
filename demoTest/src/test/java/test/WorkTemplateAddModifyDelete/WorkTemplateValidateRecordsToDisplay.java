package test.WorkTemplateAddModifyDelete;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.SettingsPage;
import Pages.SideNavigationMenuPage;
import Pages.WorkTemplateDefineDayTypesPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplateValidateRecordsToDisplay extends BaseTest
{
	WebDriver						driver;

	loginPage						loginPage				= new loginPage(BaseTest.driver);

	WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);

	WorkTemplateDefineDayTypesPage	workTemplate			= new WorkTemplateDefineDayTypesPage(BaseTest.driver);

	SettingsPage					settingsPage			= new SettingsPage(BaseTest.driver);

	SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);

	SoftAssert						softAssert				= new SoftAssert();
	
	Listeners						Listeners				= new Listeners();

	@Test
	public void workTemplatePDFValidation() throws InterruptedException, IOException

	{

		driver = initializeDriverMysql();
		
		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to  Organization > Settings Tab in Side Menu Bar");
		sideNavigationBar.clickSettingsBtn();
		workTemplateMainPage.iframeSwitch();
		
		Listeners.testStepDescription("set RecordsDisplayInSummaryReportDropDownValues");
		settingsPage.selectRecordsDisplayInSummaryReportDropDownValues("1000");
		settingsPage.selectRecordsDisplayInConfigurationSummaryDropDownValues("1000");
		settingsPage.clickSaveBtn();
		workTemplateMainPage.unselectFrame();
		
		Listeners.testStepDescription("Navigate to  Organization > WorkTemplate Tab in Side Menu Bar");
		sideNavigationBar.clickSideNavigationBtn();
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();
		
		Listeners.testStepDescription("Validate default recordsToDisplay what we set");
		workTemplateMainPage.validaterecordsToDisplayDropdown("1000");
		workTemplateMainPage.validaterecordsToDisplay(1000);
		workTemplateMainPage.unselectFrame();
		sideNavigationBar.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Again Navigate to  Organization > Settings Tab in Side Menu Bar");
		sideNavigationBar.clickSettingsBtn();
		workTemplateMainPage.iframeSwitch();
		
		Listeners.testStepDescription("set different values RecordsDisplayInSummaryReportDropDownValues");
		settingsPage.selectRecordsDisplayInSummaryReportDropDownValues("100");
		settingsPage.selectRecordsDisplayInConfigurationSummaryDropDownValues("100");
		settingsPage.clickSaveBtn();
		workTemplateMainPage.unselectFrame();
		sideNavigationBar.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to  Organization > WorkTemplate Tab in Side Menu Bar");
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();
		
		Listeners.testStepDescription("Validate default recordsToDisplay what we set");
		workTemplateMainPage.validaterecordsToDisplayDropdown("100");
		workTemplateMainPage.validaterecordsToDisplay(100);
		
		
		
	}
}
