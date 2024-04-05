package test.CategoriesActivityTagsNewOrg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.ActivityTagsPage;
import Pages.CategoryPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class ActivityTagsBulkUploadValidatePrefilldData extends BaseTest
{

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	ActivityTagsPage		ActivityTagsPage		= new ActivityTagsPage(BaseTest.driver);
	
	Listeners listeners = new Listeners();


	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void activityTagsBulkUploadValidatePrefilldData() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickactivitiesBtn();
		
		listeners.testStepDescription("Navigate Categories Tab in Side Menu Bar");
		CategoryPage.clickcategoriesBtn();
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Navigate Activity Tag Tab in Side Menu Bar");
		ActivityTagsPage.clickActivityTagTab();
		ActivityTagsPage.getWebActivityTagTableDataToComparePrefilledData();
		
		listeners.testStepDescription("Navigate to bulkUpload page");
		ActivityTagsPage.clickBulckUploadBtn();
		ActivityTagsPage.clickBulckUploadWithPrefilledDataRB();
		
		listeners.testStepDescription("Download the withPrefilledData Template");
		ActivityTagsPage.clickBulckUploadClickHereLinkToGetExcel();
		ActivityTagsPage.getWithPrefilledExcelData();
		
		listeners.testStepDescription("Compare withPrefilledData with Web Activity table");
		ActivityTagsPage.validateWithPrefilledExcelDataWithWeb();
	}
}
