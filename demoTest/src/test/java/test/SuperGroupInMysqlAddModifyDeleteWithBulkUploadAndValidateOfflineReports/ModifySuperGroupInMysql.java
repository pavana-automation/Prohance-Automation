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
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class ModifySuperGroupInMysql extends BaseTest
{

	WebDriver				driver;

	public String			superGroupNameAdd		= "Software Engineer";

	public String			superGroupNameModify	= "Imformation Technologies";

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	SoftAssert				softAssert				= new SoftAssert();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modifySuperGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();

		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();

		listeners.testStepDescription("Navigate Users > Funtions in Side Menu Bar");
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameAdd);

		listeners.testStepDescription("Modify the SuperGroup Basic Details");
		SuperGroupMysqlPage.clickModifyIconInSuperGroupTable();
		SuperGroupMysqlPage.inputSuperGroupNameModify(superGroupNameModify);
		SuperGroupMysqlPage.clickSaveBtn();

		listeners.testStepDescription("Validate the Alert Message");
		SuperGroupMysqlPage.validataSucessMsgToModifiedSuperGroupName(superGroupNameModify);

		listeners.testStepDescription("Modify the teams Mapping");
		SuperGroupMysqlPage.clickTeamsMappingTab();
		SuperGroupMysqlPage.selectTeamsChkBxToUnmap();
		SuperGroupMysqlPage.clickRemoveBtn();
		Thread.sleep(1000);
		SuperGroupMysqlPage.clickExitBtn();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameModify);

		listeners.testStepDescription("Validate Modification is reflected in web");
		List<String> webSupergroupList = SuperGroupMysqlPage.getWebSuperGroupData();
		softAssert.assertTrue(webSupergroupList.contains(superGroupNameModify));
		webSupergroupList.clear();
		System.gc();

	}
}
