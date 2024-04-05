package test.CategoriesActivityTagsNewOrg;


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

public class DeleteActivityTag extends BaseTest
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
	public void deleteActivityTag() throws InterruptedException
	{
		listeners.testStepDescription("Login Into Prohance Application");
		driver = initializeDriverMysql();
		
		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Activities Tab in Side menu bar");
		SideNavigationMenuPage.clickactivitiesBtn();
		
		listeners.testStepDescription("Navigate to Categories Tab in Side menu bar");
		CategoryPage.clickcategoriesBtn();
		
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Navigate to ActivityTag Tab in Side menu bar");
		ActivityTagsPage.clickActivityTagTab();
		
		ActivityTagsPage.searchAfterModifiedActivityTagTableTxtBx();
		
		listeners.testStepDescription("Delete the Activity Tag");
		ActivityTagsPage.clickDeleteActivityTag();
		
		CategoryPage.clcikConfirmToDeleteYesBtn();
		
		listeners.testStepDescription("Validste the Deleted Alert");
		ActivityTagsPage.validateDeletedMessageActivityTag();
	}

}
