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

public class AddUserGroupInMysql extends BaseTest
{
	public String			userGroupName			= "Production Team";

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	SoftAssert				SoftAssert				= new SoftAssert();

	Listeners				Listeners				= new Listeners();


	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void addUserGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		
		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to Users > Teams Tab in Side Menu Bar");
		SideNavigationMenuPage.clickUsersBtn();
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("Adding New UserGroup");
		UserGroupMysqlPage.clickAddNewBtn();
		
		Listeners.testStepDescription("Add Basic Details of UserGroup ");
		UserGroupMysqlPage.addDetailsForUserGroup();
		UserGroupMysqlPage.clickDetailsSaveBtn();
		
		Listeners.testStepDescription("Validate the Message Basic Details Saved Or Not");
		UserGroupMysqlPage.validateSucessMsg();
		
		Listeners.testStepDescription("Navigate to Associate Users Tab");
		UserGroupMysqlPage.clickAssociateUsersTab();
		
		Listeners.testStepDescription("Add the Users to Newly added UserGroup");
		UserGroupMysqlPage.clickAddUsersBtn();
		String mainWindow = CommonMethodsPage.navigateNextWindow();
		UserGroupMysqlPage.selectUsers();
		UserGroupMysqlPage.clickAddBtnOfUser();
		CategoryPage.navigateMainWindow(mainWindow);
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("Validate the Message showing properly");
		UserGroupMysqlPage.validateSucessMsgUserAssociation();
		
		Listeners.testStepDescription("Navigate to Work Types Tab");
		UserGroupMysqlPage.clickAssociateWorkTypesTab();
		UserGroupMysqlPage.clickAddWorkTypeBtn();
		mainWindow = CommonMethodsPage.navigateNextWindow();
		UserGroupMysqlPage.selectWorkTypeChkBx();
		
		Listeners.testStepDescription("Add Work type to Newly Added UserGroup");
		UserGroupMysqlPage.clickAddBtnOfUser();
		CategoryPage.navigateMainWindow(mainWindow);
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("Validate the Alert Messages Showing properly");
		UserGroupMysqlPage.validateSucessMsgWrokType();
		UserGroupMysqlPage.exitBtn();
		UserGroupMysqlPage.searchboxInUserGroupTableinput(userGroupName);
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
		Listeners.testStepDescription("Validate Newly added UserGroup is added in UserGroup Table");
		UserGroupMysqlPage.validateUserGroupAdd(webUserGroupDataList);
		
	}
}
