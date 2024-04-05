package MSSQLTest.SuperGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

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

public class AddSuperGroupInMSSQL extends BaseTest
{

	public String			leve2SuperGroupName		= "Leve2 Super Team";

	public String			leve1SuperGroupName		= "Leve1 Super Team";

	public String			leve0SuperGroupName		= "Leve0 Super Team";

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	SuperGroupMSSQLPage		SuperGroupMSSQLPage		= new SuperGroupMSSQLPage(BaseTest.driver);

	SoftAssert				softAssert				= new SoftAssert();


	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void addSuperGroupInMSSQL() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Users Tab");
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		
		listeners.testStepDescription("Navigate to SuperGroupTab");
		SuperGroupMSSQLPage.clickSuperGroupTab();
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Add New Super group in bulk Upload");
		SuperGroupMysqlPage.clickAddNewBtn();
		SuperGroupMSSQLPage.addleve2SuperGroupName(leve2SuperGroupName);
		SuperGroupMysqlPage.clickAddNewBtn();
		SuperGroupMSSQLPage.addleve1SuperGroupName(leve2SuperGroupName, leve1SuperGroupName);
		SuperGroupMysqlPage.clickAddNewBtn();
		SuperGroupMSSQLPage.addleve0SuperGroupName(leve2SuperGroupName, leve1SuperGroupName, leve0SuperGroupName);
		SuperGroupMSSQLPage.clickBackBtn();
		SuperGroupMSSQLPage.searchSuperGroupTxtBx(leve2SuperGroupName);
		
		listeners.testStepDescription("Validate Added values in supergroup table");
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		softAssert.assertTrue(webSuperGroupNameDataList.contains(leve2SuperGroupName));
		softAssert.assertTrue(webSuperGroupNameDataList.contains(leve1SuperGroupName));
		softAssert.assertTrue(webSuperGroupNameDataList.contains(leve0SuperGroupName));
		softAssert.assertAll();

	}

}
