package test.WorkTemplateAddModifyDelete;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkTemplateDefineDayTypesPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplateDefineDayTypesModify extends BaseTest
{

	WebDriver						driver;

	loginPage						loginPage				= new loginPage(BaseTest.driver);

	WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);

	WorkTemplateDefineDayTypesPage	workTemplate			= new WorkTemplateDefineDayTypesPage(BaseTest.driver);

	Listeners						Listeners				= new Listeners();

	SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);

	@Test
	public void defineDayTypeModify() throws InterruptedException

	{

		driver = initializeDriverMysql();
		
		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to  Organization > WorkTemplate Tab in Side Menu Bar");
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();
		
		Listeners.testStepDescription("Navigate to DefineDayTypes");
		workTemplate.clickDefineDayTypesBtn();
		workTemplate.clickDayTypeModifyIcon();
		
		Listeners.testStepDescription("Modify the DefineDayTypes");
		workTemplate.aliasNameTxtBx("Automation modified");
		workTemplate.clickDayTypeModifySaveBtn();
		
		Listeners.testStepDescription("Validate Success Message");
		workTemplate.successMessageValidation("Day Type: ' Automation modified ' modified successfully");
		
		Listeners.testStepDescription("Validate DefineDayTypes Modified or not");
		workTemplate.verifyAddedAliasInTable("Automation modified");
		workTemplate.dayTypeCloseBtn();

	}

}
