package test.WorkTemplateAddModifyDelete;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplateModify extends BaseTest
{

	WebDriver				driver;

	loginPage				loginPage			= new loginPage(BaseTest.driver);

	WorkTemplatePage		workTemplate		= new WorkTemplatePage(BaseTest.driver);

	Listeners				Listeners			= new Listeners();

	SideNavigationMenuPage	sideNavigationBar	= new SideNavigationMenuPage(BaseTest.driver);

	@Test
	public void workTemplateModify() throws InterruptedException
	{

		driver = initializeDriverMysql();

		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to  Organization > WorkTemplate Tab in Side Menu Bar");
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplate.iframeSwitch();
		
		Listeners.testStepDescription("Modify the workTemplate");
		workTemplate.modifyWorkTemplate("TemplateTestAutomation");
		workTemplate.addNameAndDescriptionModify("ChangeName", "ChangeDesc");
		workTemplate.saveBtn();
		workTemplate.navigateToWorkTimeTargets();
		workTemplate.uncheckWorkTimeTargetForMondayToThursday();
		Thread.sleep(2000);
		workTemplate.saveBtnWorkTemplate();
		
		Listeners.testStepDescription("Validate Success message");
		workTemplate.successMessageValidate("Work Time Targets modified successfully");
		workTemplate.clickWorkLoadCategoriesLabel();
		workTemplate.clickExitBtn();
		
		Listeners.testStepDescription("Validate Changes should happen in web");
		workTemplate.validateAddedTeamplateInTable("ChangeName");

	}

}
