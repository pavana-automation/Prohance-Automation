package MSSQLTest.SuperGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MSSQLPages.SuperGroupMSSQLPage;
import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.SuperGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class DeleteSuperGroupInMSSQL extends BaseTest
{

	public String			leve2SuperGroupNameModify	= "Leve2 Super Modified Team";

	public String			leve1SuperGroupNameModify	= "Leve1 Super Modified Team";

	public String			leve0SuperGroupNameModify	= "Leve0 Super Modified Team";

	WebDriver				driver;

	loginPage				loginPage					= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage		= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage			= new SuperGroupMysqlPage(BaseTest.driver);

	SuperGroupMSSQLPage		superGroupMSSQLPage			= new SuperGroupMSSQLPage(BaseTest.driver);

	CategoryPage			CategoryPage				= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage			= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners					= new Listeners();

	SoftAssert				softAssert					= new SoftAssert();

	

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void deleteSuperGroupInMSSQL() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Users Tab");
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		
		listeners.testStepDescription("Navigate to SuperGroup Tab");
		superGroupMSSQLPage.clickSuperGroupTab();
		CategoryPage.selectFrame();
		
		
		listeners.testStepDescription("Delete SuperGroup and validate it");
		SuperGroupMysqlPage.searchSuperGroupTxtBx(leve2SuperGroupNameModify);
		superGroupMSSQLPage.clickDeleteIconForLeves(leve0SuperGroupNameModify,2);
		SuperGroupMysqlPage.clcikConfirmToDeleteYesBtn();
		superGroupMSSQLPage.validateDeletedMessageSuperGroupName(leve0SuperGroupNameModify);
		
	
		SuperGroupMysqlPage.searchSuperGroupTxtBx(leve2SuperGroupNameModify);
		superGroupMSSQLPage.clickDeleteIconForLeves(leve1SuperGroupNameModify,2);
		SuperGroupMysqlPage.clcikConfirmToDeleteYesBtn();
		superGroupMSSQLPage.validateDeletedMessageSuperGroupName(leve1SuperGroupNameModify);
		
		SuperGroupMysqlPage.searchSuperGroupTxtBx(leve2SuperGroupNameModify);
		superGroupMSSQLPage.clickDeleteIconForLeves(leve2SuperGroupNameModify,2);
		SuperGroupMysqlPage.clcikConfirmToDeleteYesBtn();
		superGroupMSSQLPage.validateDeletedMessageSuperGroupName(leve2SuperGroupNameModify);
		
		
	}

}
