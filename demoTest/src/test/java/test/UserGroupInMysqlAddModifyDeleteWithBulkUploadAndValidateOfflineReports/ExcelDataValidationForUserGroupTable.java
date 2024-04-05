package test.UserGroupInMysqlAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.UserGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class ExcelDataValidationForUserGroupTable extends BaseTest
{
	public String			userGroupNameModify		= "Production Modified Teams";

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				Listeners				= new Listeners();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void excelValidateUserGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		
		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to Users > Teams Tab in Side Menu Bar");
		SideNavigationMenuPage.clickUsersBtn();
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		
		Listeners.testStepDescription("Get Web data");
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
		Listeners.testStepDescription("Get Excel reprot and data");
		UserGroupMysqlPage.clickExcelIcon();
		List<String> excelUserGroupNameDataList = UserGroupMysqlPage.getExcelDataForUserGroupTable();
		
		Listeners.testStepDescription("Validate Excel Data with Web ");
		UserGroupMysqlPage.validateExcelDataWithWebUserGroup(webUserGroupDataList, excelUserGroupNameDataList);

	}

}
