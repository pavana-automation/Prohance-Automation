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

public class SuperGroupBulkUploadDeleteMSSQL extends BaseTest
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
	public void superGroupBulkUploadDeleteForMssql() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		//listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		//listeners.testStepDescription("Navigate to Users Tab");
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		
		//listeners.testStepDescription("Navigate to SuperGroup Tab");
		superGroupMSSQLPage.clickSuperGroupTab();
		CategoryPage.selectFrame();
		
		SuperGroupMysqlPage.searchSuperGroupTxtBx("Software Engineer Level 2");
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		
		//listeners.testStepDescription("Navigate to SuperGroup BulkUpload");
		System.out.println(webSuperGroupNameDataList);
		SuperGroupMysqlPage.clickBulkUploadBtn();
		SuperGroupMysqlPage.selectWithPrefilledDataChkBx();
		
		//listeners.testStepDescription("Download the Prefilled Template");
		SuperGroupMysqlPage.clickHereDownloadTemplate();
		
		//listeners.testStepDescription("Modified the SuperGroup in BulkUpload");
		superGroupMSSQLPage.deleteSuperGroupExcelBulckUploadForMSSQL(webSuperGroupNameDataList.get(2));
		SuperGroupMysqlPage.clickChooseFileInBulkUpload();
		
		//listeners.testStepDescription("Validate the alert Message");
		ActivityTagsPage.validateBulkUploadAddMessage();
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickBackBtnInBulkUpload();
		SuperGroupMysqlPage.clickBulkUploadBtn();
		SuperGroupMysqlPage.selectWithPrefilledDataChkBx();
		
		//listeners.testStepDescription("Download the Prefilled Template");
		SuperGroupMysqlPage.clickHereDownloadTemplate();
		
		//listeners.testStepDescription("Modified the SuperGroup in BulkUpload");
		System.out.println(webSuperGroupNameDataList.toString());
		superGroupMSSQLPage.deleteSuperGroupExcelBulckUploadForMSSQL(webSuperGroupNameDataList.get(1));
		SuperGroupMysqlPage.clickChooseFileInBulkUpload();
		
		//listeners.testStepDescription("Validate the alert Message");
		ActivityTagsPage.validateBulkUploadAddMessage();
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickBackBtnInBulkUpload();
		SuperGroupMysqlPage.clickBulkUploadBtn();
		SuperGroupMysqlPage.selectWithPrefilledDataChkBx();
		
		//listeners.testStepDescription("Download the Prefilled Template");
		SuperGroupMysqlPage.clickHereDownloadTemplate();
		
		listeners.testStepDescription("Modified the SuperGroup in BulkUpload");
		superGroupMSSQLPage.deleteSuperGroupExcelBulckUploadForMSSQL(webSuperGroupNameDataList.get(0));
		SuperGroupMysqlPage.clickChooseFileInBulkUpload();
		
		//listeners.testStepDescription("Validate the alert Message");
		ActivityTagsPage.validateBulkUploadAddMessage();
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickBackBtnInBulkUpload();
		
		List<String> webSuperGroupNameDataListAfterModified = SuperGroupMysqlPage.getWebSuperGroupData();

		webSuperGroupNameDataListAfterModified.forEach(data -> {

			softAssert.assertFalse(webSuperGroupNameDataList.contains(data), "Values are not Modified through");

		});

	}

}
