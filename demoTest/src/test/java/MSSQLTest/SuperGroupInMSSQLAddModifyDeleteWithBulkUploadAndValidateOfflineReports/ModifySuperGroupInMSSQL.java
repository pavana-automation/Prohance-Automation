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

public class ModifySuperGroupInMSSQL extends BaseTest
{
	WebDriver				driver;

	public String			leve2SuperGroupName			= "Leve2 Super Team";

	public String			leve2SuperGroupNameModify	= "Leve2 Super Modified Team";

	public String			leve1SuperGroupNameModify	= "Leve1 Super Modified Team";

	public String			leve0SuperGroupNameModify	= "Leve0 Super Modified Team";

	loginPage				loginPage					= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage		= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage			= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage				= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage			= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners					= new Listeners();

	SuperGroupMSSQLPage		SuperGroupMSSQLPage			= new SuperGroupMSSQLPage(BaseTest.driver);

	SoftAssert				softAssert					= new SoftAssert();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modifySuperGroupInMSSQL() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Users Tab");
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		listeners.testStepDescription("Navigate to SuperGroup Tab");
		SuperGroupMSSQLPage.clickSuperGroupTab();
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Modify the Supergroup and verified it");
		SuperGroupMysqlPage.searchSuperGroupTxtBx(leve2SuperGroupName);
		SuperGroupMSSQLPage.clickModifyIconForLeve2();
		SuperGroupMSSQLPage.modifySuperGroupNameForLeve2(leve2SuperGroupNameModify);
		SuperGroupMysqlPage.searchSuperGroupTxtBx(leve2SuperGroupNameModify);
		SuperGroupMSSQLPage.clickModifyIconForLeves(leve2SuperGroupNameModify,3);
		SuperGroupMSSQLPage.modifySuperGroupNameForLeve1(leve2SuperGroupNameModify, leve1SuperGroupNameModify);
		SuperGroupMysqlPage.searchSuperGroupTxtBx(leve2SuperGroupNameModify);
		SuperGroupMSSQLPage.clickModifyIconForLeves(leve2SuperGroupNameModify,5);
		SuperGroupMSSQLPage.modifySuperGroupNameForLeve0(leve2SuperGroupNameModify,leve1SuperGroupNameModify,leve0SuperGroupNameModify);
	}

}
