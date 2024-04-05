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

public class ModifyUserGroupInMysql extends BaseTest
{
	public String		userGroupNameModify		= "Production Modified Team";
	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				Listeners				= new Listeners();
	
	SoftAssert			softAssert					= new SoftAssert();

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
		
		Listeners.testStepDescription("Modify the UserGroup Basic Details");
		UserGroupMysqlPage.clickEditIcon();
		UserGroupMysqlPage.modifyDetailsForUserGroup();
		UserGroupMysqlPage.clickDetailsSaveBtn();
		
		Listeners.testStepDescription("After Modified Validate the alrt Message showing Properly Or Not");
		UserGroupMysqlPage.validateModifiedSucessMsg();
		
		Listeners.testStepDescription("Navigate to Associate Users Tab ");
		UserGroupMysqlPage.clickAssociateUsersTab();
		
		Listeners.testStepDescription("Remove the users which is added in previous");
		UserGroupMysqlPage.removeUserInAssoicateUsers();
		UserGroupMysqlPage.clickRemoveUsersBtn();
		
		Listeners.testStepDescription("Validate the Alert Message");
		UserGroupMysqlPage.validateSucessMsgModifiedUserAssociation();
		
		Listeners.testStepDescription("Again added User");
		UserGroupMysqlPage.clickAddUsersBtn();
		String mainWindow = CommonMethodsPage.navigateNextWindow();
		UserGroupMysqlPage.selectUsers();
		UserGroupMysqlPage.clickAddBtnOfUser();
		CategoryPage.navigateMainWindow(mainWindow);
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("Validate the Alert Message");
		UserGroupMysqlPage.validateSucessMsgModifiedUserAssociation();
		
		Listeners.testStepDescription("Navigate to Associate Work Types ");
		UserGroupMysqlPage.clickAssociateWorkTypesTab();
		
		Listeners.testStepDescription("Remove the WorkType which is added in previous");
		UserGroupMysqlPage.removeUserInAssoicateUsers();
		UserGroupMysqlPage.clickRemoveWorkTypesBtn();
		
		Listeners.testStepDescription("Validate the Alert Message");
		UserGroupMysqlPage.validateSucessMsgWrokTypeToRemove();
		
		Listeners.testStepDescription("Again add Work Type");
		UserGroupMysqlPage.clickAddWorkTypeBtn();
		mainWindow = CommonMethodsPage.navigateNextWindow();
		UserGroupMysqlPage.selectWorkTypeChkBx();
		UserGroupMysqlPage.clickAddBtnOfUser();
		CategoryPage.navigateMainWindow(mainWindow);
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("Validate the Alert Message");
		UserGroupMysqlPage.validateSucessMsgWrokType();
		UserGroupMysqlPage.exitBtn();
		UserGroupMysqlPage.searchboxInUserGroupTableinput(userGroupNameModify);
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
		Listeners.testStepDescription("Validate Modification is Reflected to UserGroup Table");
		UserGroupMysqlPage.validateUserGroupModifyValuePrasentTheTable(webUserGroupDataList);
		

	}
}
