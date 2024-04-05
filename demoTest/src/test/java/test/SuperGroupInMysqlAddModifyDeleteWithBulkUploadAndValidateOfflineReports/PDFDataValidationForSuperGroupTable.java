package test.SuperGroupInMysqlAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.SuperGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class PDFDataValidationForSuperGroupTable extends BaseTest
{
	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				listeners				= new Listeners();
	
	SoftAssert				softAssert				= new SoftAssert();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void pdfValidationForSuperGroupTableInMysql() throws InterruptedException, IOException
	{
		driver = initializeDriverMysql();
		
		listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Navigate Users > Funtions in Side Menu Bar");
		Thread.sleep(2000);
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		SuperGroupMysqlPage.clcikPDFIconInSuperGroupTable();
		
		listeners.testStepDescription("Validate PDF With Web data");
		String pdfFileContent=SuperGroupMysqlPage.getPDFSuperGroupTableData();
		
		webSuperGroupNameDataList.forEach(data -> {
			softAssert.assertTrue(pdfFileContent.contains(data));
		});
		webSuperGroupNameDataList.clear();
		CommonMethodsPage.deleteFileByPath(CommonMethodsPage.getRecentFilePath());
		softAssert.assertAll();

	}

}
