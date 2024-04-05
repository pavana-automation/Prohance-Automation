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

public class ExcelDataValidationForSuperGroupTableForMSSQL extends BaseTest
{
	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	SuperGroupMSSQLPage		superGroupMSSQLPage		= new SuperGroupMSSQLPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	SoftAssert				softAssert				= new SoftAssert();


	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void excelValidationSuperGroupInMSSQL() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		listeners.testStepDescription("Login Into Prohance Application"); 
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Users Tab");
		SideNavigationMenuPage.clickUsersBtn();
		
		listeners.testStepDescription("Navigate to SuperGroup Tab");
		superGroupMSSQLPage.clickSuperGroupTab();
		Thread.sleep(2000);
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Validate Excel Data with Web Data");
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		SuperGroupMysqlPage.clcikExcelIconInSuperGroupTable();
		Thread.sleep(2000);
		List<String> excelSuperGroupNameDataList = SuperGroupMysqlPage.getExcelDataForSuperGroupTable();
		webSuperGroupNameDataList.forEach(webData -> {
			softAssert.assertTrue(excelSuperGroupNameDataList.contains(webData));
		});
		webSuperGroupNameDataList.clear();
		excelSuperGroupNameDataList.clear();
		CommonMethodsPage.deleteFileByPath(CommonMethodsPage.getRecentFilePath());
	}

}
