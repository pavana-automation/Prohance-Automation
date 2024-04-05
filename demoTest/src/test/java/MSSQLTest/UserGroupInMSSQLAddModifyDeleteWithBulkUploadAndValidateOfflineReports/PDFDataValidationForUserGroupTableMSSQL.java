package MSSQLTest.UserGroupInMSSQLAddModifyDeleteWithBulkUploadAndValidateOfflineReports;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CategoryPage;
import Pages.CommonMethodsPage;
import Pages.SideNavigationMenuPage;
import Pages.UserGroupMysqlPage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class PDFDataValidationForUserGroupTableMSSQL extends BaseTest
{
	public String			userGroupNameModify		= "Production Modified Teams";

	WebDriver				driver;

	loginPage				loginPage				= new loginPage(BaseTest.driver);

	SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

	UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);

	CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	Listeners				Listeners				= new Listeners();
	
	SoftAssert			softAssert					= new SoftAssert();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void pdfValidationUserGroupInMysql() throws InterruptedException, IOException
	{
		Listeners.testStepDescription("Login Into Prohance Application");
		driver = initializeDriverMssql();
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		
		Listeners.testStepDescription("Navigate to Users > Teams Tab in Side Menu Bar");
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		Listeners.testStepDescription("get web data");
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableDataWithoutSpace();
		
		Listeners.testStepDescription("Get PDF report and it data");
		UserGroupMysqlPage.clickPDFIcon();
		String pdfFileContent = UserGroupMysqlPage.getPDFUserGroupTableData();
		pdfFileContent = pdfFileContent.toString().replace(" ", "").replaceAll("\\r\\n|\\r|\\n", "");
		
		Listeners.testStepDescription("Validate PDF Data with Web ");
		UserGroupMysqlPage.validateUserGroupPDFDataWithWebData(webUserGroupDataList,pdfFileContent);

	}

}
