package MSSQLTest.SuperGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MSSQLPages.SuperGroupMSSQLPage;
import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.SuperGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class PDFDataValidationForSuperGroupTableForMSSQL extends BaseTest
{
	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	SuperGroupMSSQLPage		superGroupMSSQLPage		= new SuperGroupMSSQLPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();

	SoftAssert				softAssert				= new SoftAssert();


	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void validatePDFInSuperGroupTableForMSSQL() throws InterruptedException, IOException
	{
		driver = initializeDriverMssql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate to Users Tab");		
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		
		listeners.testStepDescription("Navigate to SuperGroup Tab");
		superGroupMSSQLPage.clickSuperGroupTab();
		CategoryPage.selectFrame();
		
		listeners.testStepDescription("Get the web data for comparison");
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		SuperGroupMysqlPage.clcikPDFIconInSuperGroupTable();
		
		 listeners.testStepDescription("Get PDF Data");
		String pdfFileContent = SuperGroupMysqlPage.getPDFSuperGroupTableData();

		listeners.testStepDescription("Validate PDF With Web data");
		webSuperGroupNameDataList.forEach(data -> {
			softAssert.assertTrue(pdfFileContent.contains(data));
		});
		webSuperGroupNameDataList.clear();
		CommonMethodsPage.deleteFileByPath(CommonMethodsPage.getRecentFilePath());
		webSuperGroupNameDataList.clear();
		softAssert.assertAll();

	}
}
