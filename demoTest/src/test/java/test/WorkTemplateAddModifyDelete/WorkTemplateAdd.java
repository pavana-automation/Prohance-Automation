package test.WorkTemplateAddModifyDelete;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplateAdd extends BaseTest
{

	WebDriver				driver;

	loginPage				loginPage			= new loginPage(BaseTest.driver);

	WorkTemplatePage		workTemplate		= new WorkTemplatePage(BaseTest.driver);

	Listeners				Listeners			= new Listeners();

	SideNavigationMenuPage	sideNavigationBar	= new SideNavigationMenuPage(BaseTest.driver);

	@Test
	public void workTemplateAdd() throws InterruptedException
	{
		driver = initializeDriverMysql();

		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		Listeners.testStepDescription("Navigate to  Organization > WorkTemplate Tab in Side Menu Bar");
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplate.iframeSwitch();
		
		Listeners.testStepDescription("Add New WorkTemplate");
		workTemplate.clickAddNewBtn();
		workTemplate.addNameAndDescription("TemplateTestAutomation", "TemplateDesc");
		workTemplate.saveBtn(); 
		
		Listeners.testStepDescription("Navigate to WorkTime Targets");
		workTemplate.navigateToWorkTimeTargets();
		workTemplate.checkWorkTimeTargetForMondayToFriday();
		workTemplate.saveBtnWorkTemplate();
		
		Listeners.testStepDescription("Validate the success Message");
		workTemplate.successMessageValidate("Work Time Targets modified successfully");
		
		Listeners.testStepDescription("Navigate to Holiday Label");
		workTemplate.clickHolidayLabel();
		
		Listeners.testStepDescription("Add Holiday with date");
		workTemplate.holidayNameInput("Diwali");
		workTemplate.selectDatePickerInHoliday();
		workTemplate.selectDateInDatePicker(2023, "Mar", "15");
		workTemplate.saveHoliday();
		
		Listeners.testStepDescription("Validate the success Message");
		workTemplate.successMessageValidate("Holidays Diwali added successfully");
		
		Listeners.testStepDescription("Navigate to TeamMapping");
		workTemplate.navigateToTeamMappingLabel();
		
		Listeners.testStepDescription("Mapping the team for workTemlate");
		workTemplate.addButtonTeamMapping();
		String childWindow = workTemplate.childWindow();
		workTemplate.checkFirstTeamInWorkTemplate();
		String selectedTeam = workTemplate.getSelectedTeamName();
		workTemplate.addTeamWorkTemaplate();
		workTemplate.mainWindow(childWindow);
		workTemplate.iframeSwitch();
		workTemplate.clickWorkLoadCategoriesLabel();
		workTemplate.clickExitBtn();
		
		Listeners.testStepDescription("Validate WorkTemlate has added");
		workTemplate.validateAddedTeamplateInTable("TemplateTestAutomation");

	}

}
