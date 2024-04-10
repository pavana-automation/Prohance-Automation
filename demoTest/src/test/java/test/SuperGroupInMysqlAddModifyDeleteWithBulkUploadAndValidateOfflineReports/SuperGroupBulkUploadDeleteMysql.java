package test.SuperGroupInMysqlAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.ActivityTagsPage;
import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.SuperGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class SuperGroupBulkUploadDeleteMysql extends BaseTest
{
	WebDriver				driver;

	public String			superGroupNameModify	= "Imformation Technologies";

	
	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	ActivityTagsPage		ActivityTagsPage		= new ActivityTagsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	SoftAssert				softAssert				= new SoftAssert();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void superGroupBulkUploadDelete() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate Users > Funtions in Side Menu Bar");
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Navigate to SuperGroup BulkUpload");
		SuperGroupMysqlPage.clickBulkUploadBtn();
		
		listeners.testStepDescription("Download the Prefilled Template");
		SuperGroupMysqlPage.selectWithPrefilledDataChkBx();
		SuperGroupMysqlPage.clickHereDownloadTemplate();
		
		listeners.testStepDescription("Delete the SuperGroup in BulkUpload");
		SuperGroupMysqlPage.deleteSuperGroupExcelBulckUpload(superGroupNameModify);
		SuperGroupMysqlPage.clickChooseFileInBulkUpload();
		
		listeners.testStepDescription("Validate the alert Message");
		ActivityTagsPage.validateBulkUploadAddMessage();
		SuperGroupMysqlPage.clickBackBtnInBulkUpload();
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		
		listeners.testStepDescription("Validate SuperGroup is Deleted in SuperGroup Table");
		softAssert.assertFalse(webSuperGroupNameDataList.contains(superGroupNameModify));
		softAssert.assertFalse(webSuperGroupNameDataList.contains(superGroupNameModify));
		webSuperGroupNameDataList.clear();
		CommonMethodsPage.deleteFileByPath(CommonMethodsPage.getRecentFilePath());
		softAssert.assertAll();

	}

}
