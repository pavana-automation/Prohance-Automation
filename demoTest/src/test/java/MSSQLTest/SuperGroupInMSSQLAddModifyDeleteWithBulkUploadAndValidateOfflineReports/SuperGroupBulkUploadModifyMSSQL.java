package MSSQLTest.SuperGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

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

public class SuperGroupBulkUploadModifyMSSQL extends BaseTest
{

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
	public void superGroupBulkUploadModifyForMssql() throws InterruptedException, IOException
	{
		//listeners.testStepDescription("Login Into Prohance Application");
		driver = initializeDriverMssql();
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();

		//listeners.testStepDescription("Navigate to Users Tab");
		SideNavigationMenuPage.clickUsersBtn();

		//listeners.testStepDescription("Navigate to SuperGroup Tab");
		Thread.sleep(2000);
		superGroupMSSQLPage.clickSuperGroupTab();
		CategoryPage.selectFrame();

		SuperGroupMysqlPage.searchSuperGroupTxtBx("Software Engineer Level 2");
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();

		//listeners.testStepDescription("Navigate to SuperGroup BulkUpload");
		SuperGroupMysqlPage.clickBulkUploadBtn();
		SuperGroupMysqlPage.selectWithPrefilledDataChkBx();

		//listeners.testStepDescription("Download the Prefilled Template");
		SuperGroupMysqlPage.clickHereDownloadTemplate();

		//listeners.testStepDescription("Modified the SuperGroup in BulkUpload");
		List<String> modifiedValues = superGroupMSSQLPage.modifySuperGroupExcelBulckUpload(webSuperGroupNameDataList);
		SuperGroupMysqlPage.clickChooseFileInBulkUpload();

		//listeners.testStepDescription("Validate the alert Message");
		ActivityTagsPage.validateBulkUploadAddMessage();
		SuperGroupMysqlPage.clickBackBtnInBulkUpload();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(modifiedValues.get(0));

		//listeners.testStepDescription("Validate Modified Value in web");
		List<String> webSuperGroupNameDataListAfterModified = SuperGroupMysqlPage.getWebSuperGroupData();

		webSuperGroupNameDataListAfterModified.forEach(data -> {
			softAssert.assertTrue(modifiedValues.contains(data), "Values are not Modified through");
		});

		softAssert.assertAll();

	}

}
