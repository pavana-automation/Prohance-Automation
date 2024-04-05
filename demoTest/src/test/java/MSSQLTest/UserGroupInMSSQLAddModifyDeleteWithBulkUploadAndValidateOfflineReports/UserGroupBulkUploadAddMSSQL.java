package MSSQLTest.UserGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MSSQLPages.UserGroupMSSQLPage;
import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.UserGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class UserGroupBulkUploadAddMSSQL extends BaseTest
{
	public String			userGroupNameModify		= "Production Modified Teams";

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);
	
	UserGroupMSSQLPage		UserGroupMSSQLPage		= new UserGroupMSSQLPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				Listeners				= new Listeners();
	
	SoftAssert			softAssert					= new SoftAssert();

	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void addUserGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		
		Listeners.testStepDescription("Navigate to Users > Teams Tab in Side Menu Bar");
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("Navigate to BulkUpload");
		UserGroupMysqlPage.clickBulkUploadBtn();
		
		Listeners.testStepDescription("Download the Blank document");
		UserGroupMysqlPage.clickBlankTemplateChkBx();
		UserGroupMysqlPage.clickHereToDownloadBulkUploadExcel();
		List<String> addBulckUploadData = UserGroupMSSQLPage.addUserGroupNamesExcelBulckUploadMSSQL();
		UserGroupMysqlPage.clickChooseFileInBulkUpload();
		
		Listeners.testStepDescription("Validate the message and File Status");
		UserGroupMysqlPage.validateSuccessMsgForUploadFile();
		UserGroupMysqlPage.clickBackBtnInBulkUpload();
		UserGroupMysqlPage.searchboxInUserGroupTableinput("Demo test Team");
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
		Listeners.testStepDescription("Validate UserGroup is added in web");
		UserGroupMysqlPage.validateAddUserGroupWithWebData(webUserGroupDataList, addBulckUploadData);
		
	}

}
