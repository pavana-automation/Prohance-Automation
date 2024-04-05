package test.CategoriesActivityTagsNewOrg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.ActivityTagsPage;
import Pages.CategoryPage;
import Pages.ClassficationPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class ActivityTagsBulkUploadDelete extends BaseTest
{

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	ClassficationPage		ClassficationPage		= new ClassficationPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	ActivityTagsPage		ActivityTagsPage		= new ActivityTagsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void activityTagsBulkUploadDelete() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();

		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Activities tab in side menu");
		SideNavigationMenuPage.clickactivitiesBtn();

		listeners.testStepDescription("Navigate Categories Tab in Side Menu Bar");
		CategoryPage.clickcategoriesBtn();
		CategoryPage.selectFrame();

		listeners.testStepDescription("Navigate Activity Tag Tab in Side Menu Bar");
		ActivityTagsPage.clickActivityTagTab();

		listeners.testStepDescription("Navigate to bulkUpload page");
		ActivityTagsPage.clickBulckUploadBtn();

		listeners.testStepDescription("Download the withPrefilledData Template");
		ActivityTagsPage.clickBulckUploadWithPrefilledDataRB();

		ActivityTagsPage.clickBulckUploadClickHereLinkToGetExcel();

		listeners.testStepDescription("Delete the Activity tag Through the Bulk Upload");
		ActivityTagsPage.deleteActivityTagExcelBulckUpload();
		ActivityTagsPage.clickChooseFileInBulkUpload();

		listeners.testStepDescription("Validate alert Message");
		ActivityTagsPage.validateBulkUploadAddMessage();
		ActivityTagsPage.clickBulkUploadBackBtn();

		listeners.testStepDescription("Validate Deleted data should not show in Activity Tag Table");
		ActivityTagsPage.getWebActivityTagTableData();
		ActivityTagsPage.validateBulkUploadDeletedWithWebData();

	}
}
