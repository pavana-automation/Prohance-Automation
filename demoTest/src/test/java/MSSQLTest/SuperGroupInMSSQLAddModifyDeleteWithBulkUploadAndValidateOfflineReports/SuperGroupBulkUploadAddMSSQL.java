package MSSQLTest.SuperGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MSSQLPages.SuperGroupMSSQLPage;
import Pages.ActivityTagsPage;
import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.SuperGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;


	public class SuperGroupBulkUploadAddMSSQL extends BaseTest{
	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	SuperGroupMSSQLPage		superGroupMSSQLPage		= new SuperGroupMSSQLPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	ActivityTagsPage		ActivityTagsPage		= new ActivityTagsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	SoftAssert				softAssert				= new SoftAssert();

	

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void superGroupBulkUploadAddForMssql() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		//listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		superGroupMSSQLPage.clickSuperGroupTab();
		CategoryPage.selectFrame();
		// listeners.testStepDescription("Navigate to SuperGroup BulkUpload");
		SuperGroupMysqlPage.clickBulkUploadBtn();
		SuperGroupMysqlPage.selectBlankTemplateChkBx();
		// listeners.testStepDescription("Download the Blank Template");
		SuperGroupMysqlPage.clickHereDownloadTemplate();
		// listeners.testStepDescription("Add SuperGroup in BulkUpload");
		HashMap<String, List<String>> addedSupergroupInBulkUploadMap = superGroupMSSQLPage.addSuperGroupNamesExcelBulckUploadForMSSQL();
		SuperGroupMysqlPage.clickChooseFileInBulkUpload();
		// listeners.testStepDescription("Validate the alert Message");
		ActivityTagsPage.validateBulkUploadAddMessage();
		SuperGroupMysqlPage.clickBackBtnInBulkUpload();
		// listeners.testStepDescription("Validate SuperGroup is Added in SuperGroup
		// Table");
		SuperGroupMysqlPage.searchSuperGroupTxtBx("Software Engineer Level 2");
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		Collections.reverse(webSuperGroupNameDataList);

		int i = 0;
		for (Entry<String, List<String>> entry : addedSupergroupInBulkUploadMap.entrySet())
		{

			softAssert.assertTrue(entry.getValue().contains(webSuperGroupNameDataList.get(i)));
			i++;

		}
		softAssert.assertAll();
	}

}
