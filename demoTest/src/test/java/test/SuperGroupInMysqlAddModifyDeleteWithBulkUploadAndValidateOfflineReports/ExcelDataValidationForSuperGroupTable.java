package test.SuperGroupInMysqlAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.SuperGroupMysqlPage;
import Pages.loginPage;
import test.ApprovePermissionForfilesInBrowser;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class ExcelDataValidationForSuperGroupTable extends BaseTest
{
	WebDriver							driver;

	loginPage							loginPage							= new loginPage(BaseTest.driver);

	SideNavigationMenuPage				SideNavigationMenuPage				= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage					SuperGroupMysqlPage					= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage						CategoryPage						= new CategoryPage(BaseTest.driver);

	CommonMethodsPage					CommonMethodsPage					= new CommonMethodsPage(BaseTest.driver);

	Listeners							listeners							= new Listeners();

	SoftAssert							softAssert							= new SoftAssert();

	ApprovePermissionForfilesInBrowser	ApprovePermissionForfilesInBrowser	= new ApprovePermissionForfilesInBrowser();

	List<String>						excelSuperGroupNameDataList;

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void excelValidationForSuperGroupTableInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();

		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();

		listeners.testStepDescription("Navigate Users > Funtions in Side Menu Bar");
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();

		listeners.testStepDescription("Validate Excel Data with Web Data");
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		SuperGroupMysqlPage.clcikExcelIconInSuperGroupTable();
		Thread.sleep(2000);

		excelSuperGroupNameDataList = SuperGroupMysqlPage.getExcelDataForSuperGroupTable();
		System.out.println(excelSuperGroupNameDataList.toString());

		webSuperGroupNameDataList.forEach(webData -> {
			softAssert.assertTrue(excelSuperGroupNameDataList.contains(webData));
		});
		webSuperGroupNameDataList.clear();
		excelSuperGroupNameDataList.clear();
		CommonMethodsPage.deleteFileByPath(CommonMethodsPage.getRecentFilePath());

	}
}
