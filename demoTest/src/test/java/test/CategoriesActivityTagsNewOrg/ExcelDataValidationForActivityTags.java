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

public class ExcelDataValidationForActivityTags extends BaseTest
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
	public void excelDataValidationForActivityTags() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Activities Tab in Side menu bar");
		SideNavigationMenuPage.clickactivitiesBtn();
		
		listeners.testStepDescription("Navigate to Categories Tab in Side menu bar");
		CategoryPage.clickcategoriesBtn();
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Navigate to ActivityTag Tab in Side menu bar");
		ActivityTagsPage.clickActivityTagTab();
		ActivityTagsPage.getWebActivityTagTableData();
		
		listeners.testStepDescription("Get Excel Reprot");
		ActivityTagsPage.clickExcelActivityTagTable();
		ActivityTagsPage.getExcelActivityTagTableData();
		
		listeners.testStepDescription("Validate Excel data and Web Data are same");
		ActivityTagsPage.validateExcelDataWithWeb();
	}

}
