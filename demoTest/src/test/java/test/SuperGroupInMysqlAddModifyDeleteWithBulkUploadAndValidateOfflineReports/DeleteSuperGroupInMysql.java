package test.SuperGroupInMysqlAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.SuperGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class DeleteSuperGroupInMysql extends BaseTest
{

	WebDriver				driver;

	public String			superGroupNameModify	= "Imformation Technologies";

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void deleteSuperGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);

		SideNavigationMenuPage.clickSideNavigationBtn();

		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		
		listeners.testStepDescription("Navigate Users > Funtions in Side Menu Bar");
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameModify);

		listeners.testStepDescription("Delete the SuperGroup");
		SuperGroupMysqlPage.clickDeleteIconInSuperGroupTable();
		SuperGroupMysqlPage.clcikConfirmToDeleteYesBtn();

		listeners.testStepDescription("Validate the Alert Message");
		SuperGroupMysqlPage.validateDeletedMessageSuperGroupName(superGroupNameModify);

	}
}
