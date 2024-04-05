package test.UserGroupInMysqlAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.UserGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class UserGroupBulkUploadModifyMysql extends BaseTest
{
	public String			userGroupNameModify		= "Production Modified Teams";

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				Listeners				= new Listeners();

	SoftAssert				softAssert				= new SoftAssert();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modifyUserGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		
		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		
		Listeners.testStepDescription("Navigate to Users > Teams Tab in Side Menu Bar");
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("Navigate to BulkUpload");
		UserGroupMysqlPage.clickBulkUploadBtn();
		
		Listeners.testStepDescription("Download the Prefilled document");
		UserGroupMysqlPage.clickWithPrefilledDataChkBx();
		UserGroupMysqlPage.clickHereToDownloadBulkUploadExcel();
		
		Listeners.testStepDescription("Modify the UserGroup Name and Description");
		String bulkUploadModify = UserGroupMysqlPage.modifySuperGroupExcelBulckUpload();
		UserGroupMysqlPage.clickChooseFileInBulkUpload();
		
		Listeners.testStepDescription("Validate Alert message is showing And File is Upload Properly");
		UserGroupMysqlPage.validateSuccessMsgForUploadFile();
		UserGroupMysqlPage.clickBackBtnInBulkUpload();
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		UserGroupMysqlPage.searchboxInUserGroupTableinput("Demo test Team Modify");
		
		Listeners.testStepDescription("Validate UserGroup is Modify in web");
		UserGroupMysqlPage.validateModifyUserGroupWithWebData(webUserGroupDataList, bulkUploadModify);

	}
}
