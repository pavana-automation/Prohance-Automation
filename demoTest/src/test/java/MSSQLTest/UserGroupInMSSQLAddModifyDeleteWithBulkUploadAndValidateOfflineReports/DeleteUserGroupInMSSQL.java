package MSSQLTest.UserGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import MSSQLPages.UserGroupMSSQLPage;
import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.UserGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class DeleteUserGroupInMSSQL  extends BaseTest
{
	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
	
	UserGroupMSSQLPage		UserGroupMSSQLPage		= new UserGroupMSSQLPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();


	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void deleteUserGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		
		listeners.testStepDescription("Navigate to Users > Teams Tab in Side Menu Bar");
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Delete the UserGroup");
		UserGroupMSSQLPage.clickDeleteIconForMSSQL();
		UserGroupMysqlPage.clickConfirmationYesBtn();
		
		listeners.testStepDescription("Validate data dependency alert showing or Not");
		UserGroupMysqlPage.clickHereRemoveDataDependency();
		String mainWindow = CommonMethodsPage.navigateNextWindow();
		
		listeners.testStepDescription("Delete the data dependency");
		UserGroupMysqlPage.selectDependentChxBxToRemoveDataDepandency();
		UserGroupMysqlPage.clickdeleteDataDepandencyBtn();
		driver.close();
		CategoryPage.navigateMainWindow(mainWindow);
		
		listeners.testStepDescription("Again delete the UserGroup");
		CategoryPage.selectFrame();
		UserGroupMysqlPage.clickDeleteIcon();
		UserGroupMysqlPage.clickConfirmationYesBtn();
		
		listeners.testStepDescription("Validate the Alert Message");
		UserGroupMysqlPage.validateSucessMsgDeleted();
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
	    listeners.testStepDescription("Validate Delete UserGroup should not show in UserGroup Table");
		UserGroupMysqlPage.validateUserGroupDeleteValuePrasentTheTable(webUserGroupDataList);

	}

}
