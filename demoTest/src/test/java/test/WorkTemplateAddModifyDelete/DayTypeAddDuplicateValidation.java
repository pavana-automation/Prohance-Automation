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

public class DayTypeAddDuplicateValidation extends BaseTest
{

	WebDriver						driver;

	loginPage						loginPage				= new loginPage(BaseTest.driver);

	WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);

	WorkTemplateDefineDayTypesPage	workTemplate			= new WorkTemplateDefineDayTypesPage(BaseTest.driver);

	Listeners						Listeners				= new Listeners();

	SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);

	@Test
	public void addDuplicateValidation() throws InterruptedException

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

		Listeners.testStepDescription("Add DefineDayTypes");
		workTemplate.clickDefineDayTypesDayTypeDropDown("WD");
		workTemplate.aliasNameTxtBx("Automation");
		workTemplate.clickAddDayTypes();

		Listeners.testStepDescription("Validate the susscess message");
		workTemplate.successMessageValidation("Day Type: ' Automation ' added successfully");

		Listeners.testStepDescription("Again try to Add DefineDayTypes as same name");
		workTemplate.verifyAddedAliasInTable("Automation");
		workTemplate.clickDefineDayTypesDayTypeDropDown("WD");
		workTemplate.aliasNameTxtBx("Automation");
		workTemplate.clickAddDayTypes();

		Listeners.testStepDescription("Validate the error Message");
		workTemplate.errorMessageValidation("Day Type: ' Automation ' already exists");
		workTemplate.clickDayTypeDeleteIcon();
		workTemplate.conformationAlertForDeleteDayType();

		Listeners.testStepDescription("Add DefineDayTypes");
		workTemplate.successMessageValidation("Day Type: ' Automation ' deleted successfully");
		workTemplate.verifyDayTypedeletedAliasInTable();
		workTemplate.dayTypeCloseBtn();

	}

}
