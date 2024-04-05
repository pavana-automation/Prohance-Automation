package test.WorkTemplateAddModifyDelete;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplateDelete extends BaseTest
{

	WebDriver				driver;

	loginPage				loginPage			= new loginPage(BaseTest.driver);

	WorkTemplatePage		workTemplate		= new WorkTemplatePage(BaseTest.driver);

	Listeners				Listeners			= new Listeners();

	SideNavigationMenuPage	sideNavigationBar	= new SideNavigationMenuPage(BaseTest.driver);

	@Test
	public void workTemplateDelete() throws Exception
	{
		driver = initializeDriverMysql();

		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to  Organization > WorkTemplate Tab in Side Menu Bar");
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplate.iframeSwitch();
		
		Listeners.testStepDescription("Add WorkTemplate to delete");
		workTemplate.clickAddNewBtn();
		workTemplate.addNameAndDescription("DeleteTemp", "deleteDesc");
		workTemplate.saveBtn();
		workTemplate.clickWorkLoadCategoriesLabel();
		workTemplate.clickExitBtn();
		
		Listeners.testStepDescription("Delete WorkTemplate");
		workTemplate.validateAddedTeamplateInTable("DeleteTemp");
		workTemplate.deleteWorkTemplate("DeleteTemp");
		
		Listeners.testStepDescription("Validate delete is heppen or not ");
		workTemplate.validateTemplateDeleted(workTemplate.validateDeletedTeamplateNotInTable("DeleteTemp"));
	}

}
