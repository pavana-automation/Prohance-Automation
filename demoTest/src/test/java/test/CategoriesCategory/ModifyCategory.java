package test.CategoriesCategory;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class ModifyCategory extends BaseTest
{
	String					mainWindow;

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modifyCategory() throws InterruptedException
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
		
		listeners.testStepDescription("Navigate to Category Tab in Side menu bar");
		CategoryPage.clickCategoryTab();
		
		listeners.testStepDescription("Modify the Category");
		CategoryPage.clickModifyIconCategory();
		CategoryPage.modifyTheCategory();
		CategoryPage.saveCategoryBtn();
		
		listeners.testStepDescription("Validate the Alert Message");
		CategoryPage.validateModifiedMessage();
		CategoryPage.serachAftermodifiedTxtBx();
		
		listeners.testStepDescription("Validate Modification is Reflected in Category Table");
		CategoryPage.validateModifiedCategory();
	}

}
