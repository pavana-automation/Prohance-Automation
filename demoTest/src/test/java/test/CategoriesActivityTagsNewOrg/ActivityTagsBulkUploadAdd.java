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
import test.Listeners;
import test.GenderalVariables;


public class ActivityTagsBulkUploadAdd extends BaseTest
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
	public void activityTagsBulkUploadAdd() throws InterruptedException, IOException
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
		
		listeners.testStepDescription("Download the Blank Template");
		ActivityTagsPage.clickBulckUploadBlankTemplateRB();
		ActivityTagsPage.clickBulckUploadClickHereLinkToGetExcel();
		
		listeners.testStepDescription("Add new Activity tag Through");
		ActivityTagsPage.addActivityTagExcelBulckUpload();
		ActivityTagsPage.clickChooseFileInBulkUpload();
		
		listeners.testStepDescription("Validate bulck upload alert");
		ActivityTagsPage.validateBulkUploadAddMessage();
		ActivityTagsPage.clickBulkUploadBackBtn();
		
		listeners.testStepDescription("Validate Activity Tag Added in the Application");
		ActivityTagsPage.getWebActivityTagTableData();
		ActivityTagsPage.validateBulkUploadAddToWebData();
		
	}


}
