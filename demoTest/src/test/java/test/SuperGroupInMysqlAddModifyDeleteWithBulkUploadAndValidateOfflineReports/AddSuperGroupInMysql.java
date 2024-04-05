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

public class AddSuperGroupInMysql extends BaseTest
{
	WebDriver				driver;

	public String			superGroupNameAdd		= "Software Engineer";

	public String			temaNameMappedValue;

	public String			pdfFileContent;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	SoftAssert				softAssert				= new SoftAssert();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void addSuperGroupInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();

		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);

		listeners.testStepDescription("Navigate Users > Funtions in Side Menu Bar");
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();

		listeners.testStepDescription("Add New Super group");
		SuperGroupMysqlPage.clickAddNewBtn();
		SuperGroupMysqlPage.inputSuperGroupName(superGroupNameAdd);
		SuperGroupMysqlPage.inputSuperGroupNameDescription(superGroupNameAdd);
		SuperGroupMysqlPage.clickSaveBtn();

		listeners.testStepDescription("Validate the Alert Message");
		SuperGroupMysqlPage.validateSucessMessageForAddSuperGroupName(superGroupNameAdd);
		SuperGroupMysqlPage.clickTeamsMappingTab();
		SuperGroupMysqlPage.clickAddTeamsBtn();
		String mainWindowTitle = CommonMethodsPage.navigateNextWindow();
		SuperGroupMysqlPage.selectTeamsChkBxToMap();
		temaNameMappedValue = SuperGroupMysqlPage.getTeamsNameMapped();

		listeners.testStepDescription("Mapping with Teams");
		SuperGroupMysqlPage.clickAddBtnTeamsMappingPage();
		CategoryPage.navigateMainWindow(mainWindowTitle);
		CategoryPage.selectFrame();

		listeners.testStepDescription("Validate the Alert Message");
		SuperGroupMysqlPage.validataSucessMsgToMappedTeams(superGroupNameAdd);
		SuperGroupMysqlPage.clickExitBtn();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameAdd);
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();

		listeners.testStepDescription("Validate the Supergroup is added in Supergroup table");
		softAssert.assertTrue(webSuperGroupNameDataList.contains(superGroupNameAdd));
		softAssert.assertTrue(webSuperGroupNameDataList.contains(temaNameMappedValue));
		webSuperGroupNameDataList.clear();
		System.gc();

	}

}
